/*
 * PROJECT II: Polynomial.java
 *
 * This file contains a template for the class Polynomial. Not all methods are
 * implemented. Make sure you have carefully read the project formulation
 * before starting to work on this file.
 *
 * This class is designed to use Complex in order to represent polynomials
 * with complex co-efficients. It provides very basic functionality and there
 * are very few methods to implement! The project formulation contains a
 * complete description.
 *
 * Remember not to change the names, parameters or return types of any
 * variables in this file! You should also test this class using the main()
 * function.
 *
 * The function of the methods and instance variables are outlined in the
 * comments directly above them.
 */

class Polynomial {
    /**
     * An array storing the complex co-efficients of the polynomial.
     */
    Complex[] coeff;

    // ========================================================
    // Constructor functions.
    // ========================================================

    /**
     * General constructor: assigns this polynomial a given set of
     * co-efficients.
     *
     * @param coeff  The co-efficients to use for this polynomial.
     */
    public Polynomial(Complex[] coeff) {
        // You need to fill in this function.
        // this.coeff = coeff;
        this.coeff = coeff;
    }

    /**
     * Default constructor: sets the Polynomial to the zero polynomial.
     */
    public Polynomial() {
        // You need to fill in this function.
       Complex[] coeffs = new Complex[1];
       coeffs[0] = new Complex();
       this.coeff = coeffs;
    }

    // ========================================================
    // Operations and functions with polynomials.
    // ========================================================

    /**
     * Create a string representation of the polynomial.
     *
     * For example: (1.0+1.0i)+(1.0+2.0i)X+(1.0+3.0i)X^2
     */
    public String toString() {
        // You need to fill in this function.
        String k = "(" + coeff[0] + ")";

        if(coeff.length > 1){
          k = k + "+(" + coeff[1] + ")X";
          if(coeff.length>2){
            for(int i = 2; i<coeff.length; i++){
              k = k +  "+(" + coeff[i] + ")X^" + i;
              }
            }
          }
        return k;
    }

    /**
     * Returns the degree of this polynomial.
     */
    public int degree() {
        // You need to fill in this function.
        if(coeff[coeff.length-1] != new Complex()){
          return coeff.length-1;
        }
        for(int i = coeff.length-1; i>=0; i--){
          if(coeff[i] == new Complex()){
            if(coeff[i-1] != new Complex()){
              return i-1;
            }
          }
        }
        return 0;
    }

    /**
     * Evaluates the polynomial at a given point z.
     *
     * @param z  The point at which to evaluate the polynomial
     * @return   The complex number P(z).
     */
    public Complex evaluate(Complex z) {
        // You need to fill in this function.
        Complex h = coeff[0];
        Complex k = z;
        if(coeff.length > 1){
          for(int i = 1; i < coeff.length; i++){
            // System.out.println("1. h: " + h + " k: " + k);
            h = h.add(coeff[i].multiply(k));
            k = k.multiply(z);
            // System.out.println("2. h: " + h + " k: " + k);
          }
        }
        return h;
    }

    /**
     * Calculate and returns the derivative of this polynomial.
     *
     * @return The derivative of this polynomial.
     */
    public Polynomial derivative() {
        // You need to fill in this function.
        if(coeff.length == 1){
          Complex[] coeffs = new Complex[1];
          coeffs[0] = new Complex();
          return new Polynomial(coeffs);
        }
        Complex[] coeffs = new Complex[coeff.length-1];
        for(int i = 0; i < coeff.length-1; i++){
          coeffs[i] = coeff[i+1].multiply(i+1);
        }

        return new Polynomial(coeffs);
    }

    // ========================================================
    // Tester function.
    // ========================================================

    public static void main(String[] args) {
        // You need to fill in this function.
        Complex[] coeff = {new Complex(1,1),new Complex(2),new Complex(5,4),new Complex(2,3)};
        Polynomial k = new Polynomial(coeff);
        System.out.println(k);
        Polynomial p = k;
        k = k.derivative();
        System.out.println(k);
        System.out.println(p);
        Complex h = k.evaluate(new Complex(2));
        System.out.println(h);
        h = k.evaluate(new Complex(0));
        System.out.println(h);
        h = k.evaluate(new Complex(10));
        System.out.println(h);
        System.out.println(k.degree());
        Complex[] coeffs = {new Complex(5)};
        Polynomial dee = new Polynomial(coeffs);
        System.out.println(dee.derivative());
    }
}
