/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna_layers_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

/**
 *
 * @author scordova
 */
public class Layer_view extends JPanel {

    int number_nucleotides = 0;
    int left_corner_nucleotide_index = 0;
    char[] dna_array_ptr;
    char[] nucleosome_windings_ptr;
    int previous_mouse_pos_x = 0;
    int drag_start_x = 0;
    int drag_end_x = 0;
    int drag_origin_y = 0;   
    boolean grab_initiated = true;
    boolean blink = true;
    long mouse_press_time =0L;
    long mouse_release_time = 0L;
    int drag_x_moments_prior_to_realease = 0;
    long time_stamp_a_few_moments_before_present = 0L;
    long last_paint_time = 0L;
    double pixel_velocity = 0.0;
    double start_nucleotide_position_floating_point = 0.0; //even though nucleotide positions are integer, keeping track of floating point values reduces rounding (quantization) noise
        int font_size = 15;
        int num_drag_time_stamps = 9;
        int drag_array_index = 0;
        long drag_time_stamps_circular_array[];
        int drag_positions_x_circular_array[];
    
    void update_slider_position(int slider_position_val) {
//        slider_position = slider_position_val;
    }

    void draw_DNA_section(Graphics g) {

        g.setFont(new Font("TimesRoman", Font.PLAIN, font_size));
        char complementary_char = 'N';
        int top_left_x = 0;
        int top_left_y = 0;

        for (int i = 0; i < 200; i++) {
            top_left_x = i * font_size;
            int start_nucleotide_index = (int) (start_nucleotide_position_floating_point /(double)font_size); 
            char cur_char = dna_array_ptr[i + start_nucleotide_index];
            switch (cur_char) {
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
            
            g.fillRect(top_left_x, top_left_y, font_size, font_size);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(cur_char), top_left_x + (int) (.25 * font_size), top_left_y + (int) (.85 * font_size));

            switch (cur_char) {
                case 'A':
                    complementary_char = 'T';
                    g.setColor(Color.BLUE);
                    break;

                case 'C':
                    complementary_char = 'G';
                    g.setColor(Color.GREEN);
                    break;

                case 'G':
                    complementary_char = 'C';
                    g.setColor(Color.RED);
                    break;

                case 'T':
                    complementary_char = 'A';
                    g.setColor(Color.BLACK);
                    break;

                default:
                    complementary_char = 'N';
                    g.setColor(Color.GRAY);
                    break;
            }
            g.fillRect(top_left_x, top_left_y + font_size, font_size, font_size);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(complementary_char), top_left_x + (int) (.25 * font_size), top_left_y + (int) (.85 * font_size) + font_size);

        }

    }

    void draw_nucleosome_windings(Graphics g) {
        int font_size = 15;

        g.setFont(new Font("TimesRoman", Font.PLAIN, font_size));

        int top_left_x = 0;
        int top_left_y = font_size * 2;
        
        for (int i = 0; i < 200; i++) {
            top_left_x = i * font_size;
            int start_nucleotide_index = (int) (start_nucleotide_position_floating_point /(double)font_size);             
            char cur_char = nucleosome_windings_ptr[i + start_nucleotide_index];
            switch (cur_char) {
                case ' ':
                    g.setColor(Color.BLACK);
                    break;

                case '%':
                    g.setColor(Color.DARK_GRAY);
                    break;

                default:
                    g.setColor(Color.BLACK);
                    break;
            }
            g.fillRect(top_left_x, top_left_y, font_size, font_size);
            g.setColor(Color.YELLOW);
            g.drawString(String.valueOf(cur_char), top_left_x + (int) (.25 * font_size), top_left_y + (int) (.85 * font_size));

        }

    }

    void draw_complimentary_section(Graphics g) {

    }

    void draw_amino_acid_codons(Graphics g) {

    }

    void draw_3mer_indicators(Graphics g) {

    }

    void draw_te_insertion_points(Graphics g) {

    }

    void draw_nucleosome_turns(Graphics g) {

    }

    void draw_palindromes(Graphics g) {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw_DNA_section(g);
        
        long cur_paint_time = System.nanoTime();
        long time_elapsed = cur_paint_time - last_paint_time;
        
        last_paint_time = cur_paint_time;
        pixel_velocity = pixel_velocity * 0.99; //deceleration factor
        start_nucleotide_position_floating_point  -= (int) (pixel_velocity * (double) time_elapsed);
        if (start_nucleotide_position_floating_point < 0.0)
        {
            start_nucleotide_position_floating_point = 0.0;
        
        }
        draw_nucleosome_windings(g);

    }

    Layer_view(char[] dna_array,
            char[] nucleosome_windings_array,
            int number_nucleotides_val) {
        super();
        dna_array_ptr = dna_array;
        nucleosome_windings_ptr = nucleosome_windings_array;
        number_nucleotides = number_nucleotides_val;
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                
                int cur_mouse_pos_x = e.getX();
                int modulo_drag_array_index = drag_array_index % num_drag_time_stamps;
                
                drag_time_stamps_circular_array[modulo_drag_array_index]  =
                        System.nanoTime();
                drag_positions_x_circular_array[modulo_drag_array_index] = cur_mouse_pos_x;

                System.out.println(
                        "Mouse Dragged: " + cur_mouse_pos_x + ", " + e.getY());
                if( grab_initiated ){
                    grab_initiated = false;
                    previous_mouse_pos_x = drag_start_x;
                } else
                {
                    
                    
                    int delta = cur_mouse_pos_x - previous_mouse_pos_x;
                start_nucleotide_position_floating_point -=  (double) delta;
                if (start_nucleotide_position_floating_point < 0.0){
                    start_nucleotide_position_floating_point = 0.0;
                }
                previous_mouse_pos_x = cur_mouse_pos_x;
                System.out.println("delta:  " +delta + "start_nucleotide_position_floating_point: " + start_nucleotide_position_floating_point);
                        }
                drag_array_index++;
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                drag_array_index = 0;                
                for (int i = 0; i < num_drag_time_stamps; i++){
                    drag_time_stamps_circular_array[i] = 0L;
                    drag_positions_x_circular_array[i] = 0;
                            }
                
                System.out.println("\nMouse Pressed: ("
                        + e.getX() + ", " + e.getY() + ")");
                
                drag_start_x = e.getX();
                mouse_press_time =System.nanoTime();
                time_stamp_a_few_moments_before_present = mouse_press_time;
    
                
                grab_initiated  = true;

            }
@Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("\nMouse Released: ("
                        + e.getX() + ", " + e.getY() + ")");
                mouse_release_time = System.nanoTime();            
                
                // compute timestamp and position of most recent drag position
                int modulo_drag_array_index = drag_array_index % num_drag_time_stamps;
                long most_recent_mouse_drag_time = drag_time_stamps_circular_array [modulo_drag_array_index];
                int most_recent_mouse_drag_pos_x = drag_positions_x_circular_array [modulo_drag_array_index];
                System.out.println("most recent index  " + modulo_drag_array_index);
                
                // compute timestamp and position of most ancient drag position available
                modulo_drag_array_index = drag_array_index-(num_drag_time_stamps-1);
                if (modulo_drag_array_index <0){
                    modulo_drag_array_index = 0;
                }                
                modulo_drag_array_index = modulo_drag_array_index % num_drag_time_stamps;
                long most_ancient_mouse_drag_time = drag_time_stamps_circular_array [modulo_drag_array_index];
                int most_ancient_mouse_drag_pos_x = drag_positions_x_circular_array [modulo_drag_array_index];                
                System.out.println("most ancient index  " + modulo_drag_array_index);
                
                
                long time_elapsed_during_drag = most_recent_mouse_drag_time - most_ancient_mouse_drag_time;
                int drag_distance_from_ancient_to_recent = most_recent_mouse_drag_pos_x - most_ancient_mouse_drag_pos_x;
                pixel_velocity = (double) drag_distance_from_ancient_to_recent/ (double) time_elapsed_during_drag;
                
                
                // over ride result if release happens 0.25 second or more motionless pause
                long time_from_drag_end_to_mouse_rel = mouse_release_time - most_recent_mouse_drag_time;                               
                if (time_from_drag_end_to_mouse_rel > 1000*1000*250){
                   pixel_velocity = 0.0;
                   System.out.println("over ride due to motionless pause ");
                }
                    
                // over ride pixel velocity if motion by mouse was too small (not generating many 
                //   time stamps associated with discrete positions
                if (drag_array_index < num_drag_time_stamps){
                   pixel_velocity = 0.0;
                   System.out.println("over ride due to too small motion ");
                }
                  
                System.out.println("most_recent_mouse_drag_time " + most_recent_mouse_drag_time);
                System.out.println("most_ancient_mouse_drag_time" + most_ancient_mouse_drag_time);                              
                
                System.out.println("pixel velocity : " + pixel_velocity);
            }
        });
        
        drag_time_stamps_circular_array = new long[num_drag_time_stamps];
        drag_positions_x_circular_array = new int[num_drag_time_stamps];
    }

}
