/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farley;

/**
 *
 * @author Amy
 */
public class FizzBuzz {

    public boolean doFizzBuzz(int start, int end) throws Exception {
        boolean ok = false;

        if (end < start) {
            throw new Exception("Invalid Number Range");

        }

        for (int i = start; i <= end; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append((i % 3 == 0) ? "fizz" : "");
            sb.append((i % 5 == 0) ? "buzz" : "");
            sb.append("".equals(sb.toString()) ? i : "");
            System.out.println(sb.toString());
        }

        return ok;
    }

}
