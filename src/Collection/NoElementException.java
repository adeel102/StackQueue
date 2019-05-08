/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
 * @author Adeel
 */
class NoElementException extends Exception {

    @Override
    public String getMessage() {
        return "NO SUCH ELEMENT TO REMOVE";
    }
}
