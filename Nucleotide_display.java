/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna_layers_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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
    double raster_fractional_width = (double) raster_width;
    char[] dna_array_ptr;
    int  top_left_corner_bp_index = 0;
    boolean grab_initiated = true;
    int drag_start_x = 0;
    int drag_start_y = 0;
    
    int previous_mouse_pos_x = 0;    
    int previous_mouse_pos_y = 0;
    
    
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
        //int dna_index = top_left_corner_bp_index * raster_width;
        int start_dna_index = top_left_corner_bp_index/skixel_height * raster_width;
        dna_stop = start_dna_index+10000;
        
        for (int dna_index = start_dna_index; dna_index < dna_stop; dna_index++) {
            row_number = (dna_index - start_dna_index) / raster_width;
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
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                System.out.println(
                        "Mouse Dragged: " + e.getX() + ", " + e.getY());
                if( grab_initiated ){
                    grab_initiated = false;
                                        previous_mouse_pos_x = drag_start_x;
                    previous_mouse_pos_y = drag_start_y;
                } else
                {
                    
                    int cur_mouse_pos_y = e.getY();
                    int cur_mouse_pos_x = e.getX();
                    int delta_y = cur_mouse_pos_y - previous_mouse_pos_y;
                    int delta_x = cur_mouse_pos_x - previous_mouse_pos_x;
                top_left_corner_bp_index -=  delta_y;
                raster_fractional_width += (double) delta_x/ (double) skixel_width;
                raster_width = (int) raster_fractional_width;
                if (top_left_corner_bp_index < 0){
                    top_left_corner_bp_index = 0;
                }
                
                previous_mouse_pos_y = cur_mouse_pos_y;
                previous_mouse_pos_x = cur_mouse_pos_x;
                
                if (raster_width < 10){
                    raster_width = 10;
                }
                
                System.out.println("delta_y:  " +delta_y + "top_left_corner_bp_index: " + top_left_corner_bp_index);
                System.out.println("delta_y:  " +delta_x + "raster_width: " + raster_width);                
                        }
                
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("\nMouse Pressed: ("
                        + e.getX() + ", " + e.getY() + ")");

                drag_start_x = e.getX();
                drag_start_y = e.getY();
                grab_initiated  = true;

            }

        });
        
        
        
    }
}
