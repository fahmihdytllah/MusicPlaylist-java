/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mp3player_playlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


/**
 *
 * @author Fahmi
 */
public class Mp3player_playlist {

    JFileChooser fc = new JFileChooser();
    ArrayList ls = new ArrayList();
    
    public void add(JFrame frame){
        //agar bisa memilih banyak file
        fc.setMultiSelectionEnabled(true);
        
        int fileValid = fc.showOpenDialog(frame);
        
        //jika klik cancel
        if (fileValid == JFileChooser.CANCEL_OPTION) {
            return;
            
        } else if (fileValid == JFileChooser.APPROVE_OPTION) {
            File[] file = fc.getSelectedFiles();
            ls.addAll(Arrays.asList(file));
        
        }
    }
    
        ArrayList getDaftarLagu(){
            return ls;
        }
        
        FileOutputStream fos;
        ObjectOutputStream oos;
        
        public void simpanPlaylist(JFrame frame) {
        fc.setMultiSelectionEnabled(true);
        int valid = fc.showOpenDialog(frame);
        
        if (valid == JFileChooser.CANCEL_OPTION){
            return;
        } else if (valid == JFileChooser.APPROVE_OPTION){
        File[] pls = fc.getSelectedFiles();
        
            try {
                fos = new FileOutputStream(pls + ".tgr");
                oos = new ObjectOutputStream(fos);
                
                for (int i = 0; i < ls.size(); i++){
                    File tmp = (File) ls.get(i);
                    oos.writeObject(tmp);
                }
                oos.close();
            } catch (IOException e) {
                System.err.println("Gagal simpan playlist: ");
            }
        }
        }

    FileInputStream fis;
    ObjectInputStream ois;
    
    public void bukaPlaylist(JFrame frame){
        fc.setMultiSelectionEnabled(true);
        int valid = fc.showOpenDialog(frame);
        
        if (valid == JFileChooser.CANCEL_OPTION){
            return;
        } else if (valid == JFileChooser.APPROVE_OPTION) {
            File pls = fc.getSelectedFile();
            try {
                    fis = new FileInputStream(pls);
                    ois = new ObjectInputStream(fis);
                    
                    File tmp;
                    while ((tmp = (File) ois.readObject()) != null) {
                        ls.isEmpty();
                    }
                    ois.close();  
            }catch (IOException | ClassNotFoundException e) {
                System.err.println("Gagal buka playlist: " + e);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
