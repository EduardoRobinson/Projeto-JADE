
import jade.core.Runtime;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.wrapper.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Runtime rt=Runtime.instance();
        Profile p=new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST,"localhost");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc=rt.createMainContainer(p);
        AgentController ac1,ac0,ac2,ac3,ac4,ac5;
        Scanner teclado= new Scanner(System.in);
        String []argumentos0= {"Raio","500"};
        String []argumentos1= {"Yetz","400"};
        String []argumentos2= {"Gabriel","Carlos","Lucas","300"};
        String []argumentos3={"Mylon","Ezreal","Lulu","500"};
        String []argumentos4={"Yetz","Marcos","Alemão","600"};
        String []argumentos5={"Yoda","Ayel","Luis","450"};
        try {
            ac0=cc.createNewAgent("Agente0", "Agente", argumentos0);
            ac1=cc.createNewAgent("Agente1", "Agente", argumentos1);
            ac2=cc.createNewAgent("Agente2", "Agente2", argumentos2);
            ac3=cc.createNewAgent("Agente3", "Agente2", argumentos3);
            ac4=cc.createNewAgent("Agente4", "Agente2", argumentos4);
            ac5=cc.createNewAgent("Agente5", "Agente2", argumentos5);
            System.out.println("Agente0 esta procurando o item "+argumentos0[0]);
            System.out.println("Agente1 esta procurando o item "+argumentos1[0]);
            ac0.start();
            ac1.start();
            ac2.start();
            ac3.start();
            ac4.start();
            ac5.start();
        } catch(StaleProxyException e) {
            e.printStackTrace();
        }



    }

}
