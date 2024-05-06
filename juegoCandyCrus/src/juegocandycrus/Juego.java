package juegocandycrus;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Juego {
 JFrame ventana;
 JLabel mat[][];
 int matriz[][];
 Random aleatorio;
 
   public Juego(){
    ventana =new JFrame("juego de pelotas");
    ventana.setBounds(0, 0, 518, 538);
    ventana.setLayout(null);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    mat =new JLabel [10][10];
    matriz=new int [10][10];
    aleatorio=new Random();
    
    for(int i=0;i<mat.length;i++){
        for(int j=0;j<mat.length;j++){
            mat[i][j]=new JLabel();
            mat[i][j].setBounds(0+i*50, 0+j*50, 50,50);
            matriz[i][j]=aleatorio.nextInt(4)+1;
           mat[i][j].setIcon(new ImageIcon("imagenes/"+matriz[i][j]+".jpg"));
            mat[i][j].setVisible(true);
            ventana.add(mat[i][j]);
        }
    }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
            mat[i][j].addMouseListener(new MouseAdapter(){
                 @Override
                 public void mouseClicked(MouseEvent ev) {
                    for(int k=0; k<mat.length;k++) {
                        for(int l=0;l<mat.length;l++){
                                 if(mat[k][l]==ev.getSource()){
                                System.out.println("posicion"+k+""+l);
                                recursiva(k , l,matriz[k][l]);
                            }
                         }
                }  
                    
                    
            for(int m=0; m<mat.length;m++) {              
             for(int k=0; k<mat.length;k++) {
                        for(int l=0;l<mat.length;l++){
                            if (l>0&&matriz [k][l]==-2){
                             matriz[k][l]=matriz[k][l-1];
                            matriz[k][l-1]=-2;
                                }
                            mat[k][l].setIcon(new ImageIcon("imagenes/"+matriz[k][l]+".jpg"));
                        }
                     }    
                  }
            
                } } );

            }
        }
    
     
    
    ventana.setVisible(true);
   }
   public void recursiva(int px, int py, int color){
       
       if(color!=-1)
           matriz[px][py]=-1;
       if(color == -1)
            matriz[px][py]=-2;
       
       
       mat[px][py].setIcon(new ImageIcon("imagenes/"+matriz [px] [py]+".jpg"));
       
       if(px <9 && matriz[px+1][py]== color)
           recursiva( px+1,py, color);
       if(px>0 &&matriz[px-1][py]==color)
         recursiva( px-1,py, color); 
       
       if(px <9 && matriz[px][py+1]== color)
           recursiva( px,py+1, color);
       if(px >0 && matriz[px][py-1]== color)
           recursiva( px,py-1, color);
   }
    public static void main(String[] args) {
     Juego obj=new Juego();
    }

   
    
}