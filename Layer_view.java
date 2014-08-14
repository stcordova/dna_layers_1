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

    char[] dna_array_ptr;

    
    void update_slider_position( int slider_position_val){
        
    }    
  
    void draw_DNA_section(Graphics g){
            int font_size = 15;

            g.setFont(new Font("TimesRoman", Font.PLAIN, font_size));

    for (int i = 0; i < 30; i++) {
    g.setColor(Color.BLACK); 
    g.fillRect(25+font_size*0+font_size*i*4, 12 , 15*4,15);    
    g.setColor(Color.WHITE);
    g.drawString("A", 25+font_size*0+font_size*i*4,25);    
    g.setColor(Color.red);      
    g.drawString("C", 25+font_size*1+font_size*i*4,25);
    g.setColor(Color.green);      
    g.drawString("G", 25+font_size*2+font_size*i*4,25);
    g.setColor(Color.BLUE);      
    g.drawString("T", 25+font_size*3+font_size*i*4,25);
    
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
        
        
    }
    
    Layer_view(char[] dna_array, int number_nucleotides_val){
        super();
        dna_array_ptr = dna_array;
        number_nucleotides = number_nucleotides_val;        
    }
    
    
}
