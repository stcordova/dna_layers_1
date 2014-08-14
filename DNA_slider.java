/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna_layers_1;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author scordova
 */
public class DNA_slider extends JSlider {

    int slider_value = 0;

    void update_slider_state() {
        slider_value = this.getValue();
        System.out.println("Text: " + slider_value);
    }

    DNA_slider(int number_nucleotides) {
//        super(JSlider.HORIZONTAL, 0, 1000, 0);//direction , min , max , current
        super(JSlider.HORIZONTAL, 0, number_nucleotides, 0);//direction , min , max , current        
        super.setFont(new Font("Tahoma", Font.BOLD, 12));
        super.setMajorTickSpacing(100);
        super.setMinorTickSpacing(25);
//        super.setPaintLabels(true);
//        super.setPaintTicks(true);
//        super.setPaintTrack(true);
        super.setAutoscrolls(true);
        super.setPreferredSize(new Dimension(500, 100));

        class Slider_listener implements ChangeListener {

            public void stateChanged(ChangeEvent e) {
                update_slider_state();
            }
        }

        Slider_listener slider_listener = new Slider_listener();

        super.addChangeListener(slider_listener);
    }

}
