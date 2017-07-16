/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP3Player;

import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;

/**
 *
 * @author andreslietti
 */
public class Player {

    private BasicPlayer player;

    public Player() {
        player = new BasicPlayer();
    }

    public void Play() throws Exception {
        player.play();
    }

    public void OpenFile(String ruta) throws Exception {
        player.open(new File(ruta));
    }

    public void Pause() throws Exception {
        player.pause();
    }

    public void Resume() throws Exception {
        player.resume();
    }

    public void Stop() throws Exception {
        player.stop();
    }

    public static void main(String args[]) {
        try {
            Player my_player = new Player();
            my_player.OpenFile("c:/mi_archivo_de_musica.mp3");
            my_player.Play();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
