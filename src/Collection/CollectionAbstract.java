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
public  abstract class CollectionAbstract {
    
    public abstract Object peek () throws NoElementException;
    
    public abstract boolean equals(Queue queue);
    public abstract boolean equals(Stack stack);
    
}
