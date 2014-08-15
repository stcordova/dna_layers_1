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
public class Nucleosome_windings {
        int number_nucleotides = 0;
    char[] nucleosome_windings_array;
    String fasta_file_name;


        Nucleosome_windings(){
       fasta_file_name = "default test file, nucleosome ";
       int iterations = 1000*1000*5;
       number_nucleotides = iterations * 10;
       nucleosome_windings_array = new char[number_nucleotides];
       for (int i=0; i< iterations; i++){
           nucleosome_windings_array[i*10+0] = ' ';
           nucleosome_windings_array[i*10+1] = ' ';
           nucleosome_windings_array[i*10+2] = ' ';
           nucleosome_windings_array[i*10+3] = ' ';
           nucleosome_windings_array[i*10+4] = ' ';
           nucleosome_windings_array[i*10+5] = ' ';
           nucleosome_windings_array[i*10+6] = ' ';
           nucleosome_windings_array[i*10+7] = ' ';
           nucleosome_windings_array[i*10+8] = ' ';
           nucleosome_windings_array[i*10+9] = '%';           
           
       }
    }

    
}
