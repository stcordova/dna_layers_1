/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna_layers_1;

import javax.swing.JFrame;

/**
 *
 * @author scordova
 */
public class Dna_layers_1 {

    Dna_layers_1() throws InterruptedException {
        DNA_strand dna_strand = new DNA_strand();
        Nucleotide_display nucleotide_display = new Nucleotide_display(dna_strand.nucleotide_array,dna_strand.number_nucleotides);

        JFrame nucleotide_frame = new JFrame("Nucleotide Display");
        nucleotide_frame.add(nucleotide_display);
        nucleotide_frame.setSize(300, 400);
        nucleotide_frame.setVisible(true);
        nucleotide_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DNA_slider dna_slider = new DNA_slider(dna_strand.number_nucleotides);

        JFrame slider_frame = new JFrame("DNA Slider");
        slider_frame.setLocation(200, 200);
        slider_frame.add(dna_slider);
        slider_frame.setSize(400, 100);
        slider_frame.setVisible(true);
        slider_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Layer_view layer_view = new Layer_view(dna_strand.nucleotide_array,dna_strand.number_nucleotides);

        JFrame layer_view_frame = new JFrame("Layer view");
        layer_view_frame.setLocation(400, 200);
        layer_view_frame.add(layer_view);
        layer_view_frame.setSize(700, 400);
        layer_view_frame.setVisible(true);
        layer_view_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          while (true) {
            layer_view.repaint();        
            nucleotide_display.repaint();
            Thread.sleep(50);
        }
        
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        new Dna_layers_1();
    }

}
