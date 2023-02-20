package com.arao.challenges.codility;

/**
 * Write a function that accepts a positive number N.
 * The function should console log a pyramid shape with N levels using the # character.  Make sure the pyramid has
 * spaces on both the left *and* right hand sides
 *
 * piramide(1)
 *        '#'
 *
 * piramide(2)
 *        ' # '
 *        '###'
 *
 * piramide(3)
 *
 * 	   '  #  '
 *     ' ### '
 *     '#####'
 *
 * piramide(4)
 *
 *    '   #   '
 *    '  ###  '
 *    ' ##### '
 * 	  '#######'
 */
public class PyramidBuilder {

    public static void printPyramid(int levels) {
        int elements = 1;
        int count = levels-1;
        String spaces = "";
        for (int i = 0; i < levels; i++) {
            spaces = count > 0 ? String.format("%"+count+"s", "") : "";

            System.out.print(spaces);
            for (int x = 0; x < elements; x++) {
                System.out.print("#");
            }
            System.out.print(spaces);

            count--;
            elements += 2;
            System.out.println();
        }
    }
}
