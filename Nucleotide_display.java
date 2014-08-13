/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna_layers_1;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author scordova
 */
public class Nucleotide_display extends JPanel {
    int x = 50;
    int y = 50;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
//                String text1 = Integer.toString(slider_val);
g.drawString("test", x, y);
    }

    Nucleotide_display(char[] dna_array) {

    }
}
