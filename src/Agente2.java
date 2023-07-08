
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;

public class Agente2 extends Agent{
    private static final long serialVersionUID = 1L;
    int verifica=0;


    protected void setup() {
        Object args[]=getArguments();
        ArrayList<String> valores = new ArrayList();
        String preco=args[args.length-1].toString();
        String aux = null;
        int i;
        for (i = 0; i < args.length-1; i++) {
            aux = args[i].toString();
            valores.add(aux);
        }
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                    ACLMessage msg=receive();
                    if(msg!=null){
                        int i;
                        int quebra=0;
                        String texto=msg.getContent().toString();
                        char backspace=' ';
                        for(i=0;i< texto.length();i++){
                            if(texto.charAt(i)==backspace){
                                quebra=i;
                            }
                        }
                        String mensagem="";
                        for(i=0;i<quebra;i++){
                            mensagem=mensagem+texto.charAt(i);
                        }
                        String precoOferecido="";
                        for(i=quebra+1;i<texto.length();i++){
                            precoOferecido=precoOferecido+texto.charAt(i);
                        }
                        System.out.println();
                        ACLMessage repost=msg.createReply();
                        for(i=0;i<valores.size();i++){
                            if(mensagem.compareTo(valores.get(i))==0){
                                verifica=1;
                                String oferta=getLocalName().toString();
                                System.out.println(oferta+" possui o item buscado");

                                if(oferta.compareTo("Agente2")==0) {
                                    System.out.println(oferta + " oferece um valor de " + preco);
                                    if (Integer.parseInt(precoOferecido) >= Integer.parseInt(preco)) {
                                        System.out.println("Oferta aceita pelo  "+getLocalName());
                                        repost.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        repost.setContent("Oferta aceita pelo vendedor!");
                                        valores.remove(i);
                                        send(repost);
                                    }else{
                                        repost.setPerformative(ACLMessage.REJECT_PROPOSAL);
                                        System.out.println("Oferta recusada pelo  "+getLocalName());
                                        repost.setContent("Oferta recusada pelo vendedor!");
                                        send(repost);
                                    }
                                }

                                if(oferta.compareTo("Agente3")==0){
                                    System.out.println(oferta+" oferece um valor de "+preco);
                                    if(Integer.parseInt(precoOferecido)>=Integer.parseInt(preco)){
                                        System.out.println("Oferta aceita pelo  "+getLocalName());
                                        repost.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        repost.setContent("Oferta aceita pelo vendedor!");
                                        valores.remove(i);
                                        send(repost);
                                    }else{
                                        repost.setPerformative(ACLMessage.REJECT_PROPOSAL);
                                        System.out.println("Oferta recusada pelo  "+getLocalName());
                                        repost.setContent("Oferta recusada pelo vendedor!");
                                        send(repost);
                                    }
                                }

                                if(oferta.compareTo("Agente4")==0){
                                    System.out.println(oferta+" oferece um valor de "+preco);
                                    if(Integer.parseInt(precoOferecido)>=Integer.parseInt(preco)){
                                        System.out.println("Oferta aceita pelo  "+getLocalName());
                                        repost.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        repost.setContent("Oferta aceita pelo vendedor!");
                                        valores.remove(i);
                                        send(repost);
                                    }else{
                                        repost.setPerformative(ACLMessage.REJECT_PROPOSAL);
                                        System.out.println("Oferta recusada pelo  "+getLocalName());
                                        repost.setContent("Oferta recusada pelo vendedor!");
                                        send(repost);
                                    }

                                }

                                if(oferta.compareTo("Agente5")==0){
                                    System.out.println(oferta+" oferece um valor de "+preco);
                                    if(Integer.parseInt(precoOferecido)>=Integer.parseInt(preco)){
                                        System.out.println("Oferta aceita pelo  "+getLocalName());
                                        repost.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        repost.setContent("Oferta aceita pelo vendedor!");
                                        valores.remove(i);
                                        send(repost);
                                    }else{
                                        repost.setPerformative(ACLMessage.REJECT_PROPOSAL);
                                        System.out.println("Oferta recusada pelo  "+getLocalName());
                                        repost.setContent("Oferta recusada pelo vendedor!");
                                        send(repost);
                                    }
                                }

                            }
                        }
                        if(verifica==0){
                            System.out.println(getLocalName()+" não possui o item");
                        }
                    }else block();
            }
        });


    }
    protected void takeDown() {

    }

}
