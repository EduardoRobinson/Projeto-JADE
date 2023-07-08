
import jade.core.Agent;
import jade.core.*;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Agente extends Agent{
    private static final long serialVersionUID = 1L;

    protected void setup() {
        Object args[]=getArguments();
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                ACLMessage msg=new ACLMessage(ACLMessage.INFORM);
                if(args!=null) {
                    String buscado = args[0].toString(),preco=args[1].toString();
                    msg.setContent(buscado+" "+preco);
                    msg.addReceiver(new AID("Agente2", AID.ISLOCALNAME));
                    msg.addReceiver(new AID("Agente3", AID.ISLOCALNAME));
                    msg.addReceiver(new AID("Agente4", AID.ISLOCALNAME));
                    msg.addReceiver(new AID("Agente5", AID.ISLOCALNAME));
                    msg.addReceiver(new AID("Agente6", AID.ISLOCALNAME));
                    send(msg);
                }
            }


        });
        addBehaviour(new CyclicBehaviour() {
            public void action() {
                MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL);
                mt = MessageTemplate.or(mt, MessageTemplate.MatchPerformative(ACLMessage.REJECT_PROPOSAL));
                ACLMessage resposta = receive(mt);
                if (resposta != null) {
                    if (resposta.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
                        System.out.println("\nResultado da negociação:"+resposta.getContent()+"\n");
                    } else {
                        System.out.println("\nResultado da negociação:"+resposta.getContent()+"\n");
                    }
                }

            }
        });



    }
    protected void takeDown() {

    }

}
