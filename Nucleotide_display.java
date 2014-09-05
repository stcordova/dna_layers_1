/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna_layers_1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author scordova
 */
public class Nucleotide_display extends JPanel {

    int origin_x = 50;
    int origin_y = 50;
    int skixel_width = 2;
    int skixel_height = skixel_width;
    int number_nucleotides = 0;
    int raster_width = 40;
    char[] dna_array_ptr;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
//                String text1 = Integer.toString(slider_val);
//g.drawString("test", x, y);
        int dna_start = 0;
        int dna_stop = 10000;
        int row_number = 0;
        int top_left_x = 0;
        int top_left_y = 0;
        
        
        for (int dna_index = 0; dna_index < dna_stop; dna_index++) {
            row_number = dna_index / raster_width;
            top_left_y = row_number * skixel_height;
            top_left_x = (dna_index % raster_width)*skixel_width;
            switch (dna_array_ptr[dna_index]) {
                case 'A':
                    g.setColor(Color.BLACK);
                    break;
                    
                case 'C':
                    g.setColor(Color.RED);
                    break;
                    
                case 'G':
                    g.setColor(Color.GREEN);
                    break;
                    
                case 'T':
                    g.setColor(Color.BLUE);
                    break;
                    
                default:
                    g.setColor(Color.GRAY);
                    break;
            }
            g.fillRect(top_left_x, top_left_y, skixel_width, skixel_height);
        }
        
    }
    
    void update_slider_position( int slider_position_val){
        
    }
    
    Nucleotide_display(char[] dna_array, int number_nucleotides_val) {
        super();
        dna_array_ptr = dna_array;
        number_nucleotides = number_nucleotides_val;
        
        
    }
}
