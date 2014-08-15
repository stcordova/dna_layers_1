/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dna_layers_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author scordova
 */
public class Layer_view extends JPanel{
    
    int number_nucleotides = 0;
    int slider_position = 0;
    char[] dna_array_ptr;
    char[] nucleosome_windings_ptr;
    
    void update_slider_position( int slider_position_val){
        slider_position = slider_position_val;
    }    
  
    void draw_DNA_section(Graphics g){
            int font_size = 15;

            g.setFont(new Font("TimesRoman", Font.PLAIN, font_size));
    char complementary_char = 'N';
    int top_left_x = 0;
    int top_left_y = 0;
    
    for (int i = 0; i < 200; i++) {
       top_left_x = i * font_size;
       char cur_char = dna_array_ptr[i + slider_position];
       switch ( cur_char ){
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
    g.fillRect(top_left_x, top_left_y,font_size, font_size);
    g.setColor(Color.WHITE);
    g.drawString(String.valueOf(cur_char), top_left_x+ (int)(.25*font_size), top_left_y+(int) (.85*font_size));
    
    
       switch ( cur_char ){
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
    g.fillRect(top_left_x, top_left_y + font_size,font_size, font_size);
    g.setColor(Color.WHITE);
    g.drawString(String.valueOf(complementary_char), top_left_x+ (int)(.25*font_size), top_left_y+(int) (.85*font_size)+font_size);
    
    }
        
    }

    void draw_nucleosome_windings (Graphics g){
            int font_size = 15;

           g.setFont(new Font("TimesRoman", Font.PLAIN, font_size));
    
    int top_left_x = 0;
    int top_left_y = font_size * 2;
    
    for (int i = 0; i < 200; i++) {
       top_left_x = i * font_size;
       char cur_char = nucleosome_windings_ptr[i + slider_position];
       switch ( cur_char ){
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
    g.fillRect(top_left_x, top_left_y,font_size, font_size);
    g.setColor(Color.YELLOW);
    g.drawString(String.valueOf(cur_char), top_left_x+ (int)(.25*font_size), top_left_y+(int) (.85*font_size));
    
    
    }
    
    }
    
    void draw_complimentary_section(Graphics g){
        
    }
    
    void draw_amino_acid_codons(Graphics g){
        
    }
    
    void draw_3mer_indicators (Graphics g){
        
    }
    
    void draw_te_insertion_points (Graphics g){
        
    }
 
    void draw_nucleosome_turns (Graphics g){
        
    }
    
    void draw_palindromes (Graphics g){
        
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw_DNA_section(g);
        draw_nucleosome_windings(g);
        
    }
    
    Layer_view(char[] dna_array, 
            char[] nucleosome_windings_array,
            int number_nucleotides_val){
        super();
        dna_array_ptr = dna_array;
        nucleosome_windings_ptr = nucleosome_windings_array;
        number_nucleotides = number_nucleotides_val;        
    }
    
    
}
