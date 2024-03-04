public class Link {
    public String bookName;
    public int millionsSold;
    public Link next;

    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display(){
        System.out.println(bookName + ": " + millionsSold + ",000,000");
    }


    public String toString() {
        return bookName;
    }

     static class LinkList{
        public  Link firstlink;
        LinkList(){
            firstlink =null;
        }

        public  boolean isEmpty(){
            return(firstlink==null);
        }

        public void insertLink(String bookName, int millionsSold){
            Link newLink = new Link(bookName, millionsSold);
            newLink.next = firstlink;
            firstlink = newLink;
        }

        public  Link removeFirst(){
            Link linkReference = firstlink;
            if (!isEmpty()){
                firstlink = firstlink.next;
            } else {
                System.out.println("Empty LinkedList");
            }
            return linkReference;
        }

        public Link find(String bookname){
            Link theLink = firstlink;
            if (!isEmpty()){
                while (theLink.bookName != bookname){
                    if (theLink.next == null){
                        return null;
                    }else {
                        theLink = theLink.next;
                    }
                }
            }else {
                System.out.println("Empty linkedList");
            }
            return  theLink;
        }

        public Link removeLink(String bookname){
            Link currentLInk = firstlink;
            Link previousLInk = firstlink;

            while (currentLInk.bookName != bookname){
                if (currentLInk.next == null){
                    return null;
                }else {
                    previousLInk = currentLInk;
                    currentLInk = currentLInk.next;
                }
            }
            if (currentLInk != firstlink){
                firstlink = firstlink.next;
            }else{
                previousLInk.next = currentLInk.next;
            }
            return currentLInk;
        }

        public void  display(){
            Link theLink = firstlink;
            while (theLink != null){
                theLink.display();
                System.out.println("Next Link: " + theLink.next);
                theLink = theLink.next;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        LinkList theLinkedList = new LinkList();

        theLinkedList.insertLink("Don Quixote", 500);
        theLinkedList.insertLink("a Table of cities", 200);
        theLinkedList.insertLink("the lord of the Rings", 150);
        theLinkedList.insertLink("Harry Potter", 107);

        theLinkedList.removeFirst();



        System.out.println(theLinkedList.find("a Table of cities").bookName + " Was found");

        theLinkedList.removeLink("Don Quixote");
        theLinkedList.display();
    }
}
