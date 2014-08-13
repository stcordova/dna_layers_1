/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dna_layers_1;

/**
 *
 * @author scordova
 */
public class DNA_strand {
    
    int number_nucleotides = 0;
    char[] nucleotide_array;
    String fasta_file_name;
           
    DNA_strand(){
       fasta_file_name = "default test file, repeat acgtn ";
       int iterations = 1000*1000*10;
       number_nucleotides = iterations * 5;
       nucleotide_array = new char[number_nucleotides];
       for (int i=0; i< iterations; i++){
           nucleotide_array[i*5+0] = 'A';
           nucleotide_array[i*5+1] = 'C';
           nucleotide_array[i*5+2] = 'G';
           nucleotide_array[i*5+3] = 'T';
           nucleotide_array[i*5+4] = 'N';
       }
    }
    
}
