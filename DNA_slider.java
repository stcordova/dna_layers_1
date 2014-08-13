/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dna_layers_1;

import java.awt.Dimension;
import java.awt.Font;
import javafx.scene.control.Slider;
import javax.swing.JSlider;

/**
 *
 * @author scordova
 */
public class DNA_slider extends JSlider{
    
    DNA_slider (){
      super(JSlider.HORIZONTAL,0,1000,0);//direction , min , max , current
        super.setFont(new Font("Tahoma", Font.BOLD, 12));
        super.setMajorTickSpacing(100);
        super.setMinorTickSpacing(25);
        super.setPaintLabels(true);
        super.setPaintTicks(true);
        super.setPaintTrack(true);
        super.setAutoscrolls(true);
        super.setPreferredSize(new Dimension(500, 500));
      
    }
}
