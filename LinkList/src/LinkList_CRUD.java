import java.util.Scanner;


public class LinkList_CRUD {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

public static class LinkedList {
        Scanner sc = new Scanner(System.in);
        Node head = null; // Declare head at class level

        public void createList(int n) {
            Node temp = null; // Temporary node reference

            for (int i = 0; i < n; i++) {
                System.out.println("Enter Linklist data for " + i + ":");
                int value = sc.nextInt();
                Node newNode = new Node(value);

                if (head == null) {
                    head = newNode; // First node becomes head
                    temp = head; // Initialize temp to head
                } else {
                    temp.next = newNode; // Link the new node
                    temp = newNode; // Move temp to the new node
                }
            }
        }

        public void insertAtStart()
        {
            System.out.println("Enter Linklist data for start at node:");
            int value = sc.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode; // First node becomes head
                newNode = head; // Initialize temp to head
            } else {
                newNode.next = head;
                head =newNode;
            }

        }

    public void insertAtEnd()
    {
        Node temp = head;
        System.out.println("\n Enter Linklist data at end at node:");
        int value = sc.nextInt();
        Node newNode = new Node(value);

       while(temp.next !=null){
           temp = temp.next;
       }
       temp.next = newNode;
       //newNode.next = null;

    }


    public void enterAtPos(int pos)
    {
        Node temp = head;
        System.out.println("\n Enter Linklist data at " +pos+ " at node:");
        int value = sc.nextInt();
        Node newNode = new Node(value);
        for(int i=0;i<pos-2;i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode ;
    }


    public void deleteList()
    {
        Node temp = head;
        head = head.next;
    }

    public void deletelastList()
    {
        Node curr = head;
        while(curr.next.next!=null){
            curr = curr.next;
        }
        curr.next =null;
    }

    public Node deleteAtPos(int pos_del){
            Node curr =head;
//            Node First = null;

            if(curr==null) return head;
            if(pos_del==1){
                head = head.next;
            }
            for(int i=0;i<pos_del-2;i++){
                curr = curr.next;
            }
            curr.next = curr.next.next;
        return curr;
    }

    public void search(int link_data){
            Node curr = head;
            int pos = 1;
            while(curr!=null){
             if(curr.data == link_data){
                 System.out.println("Node found for data "+link_data+ " at " +pos );
                 break;
             }
             else {
                 curr = curr.next;
                     pos++;
             }}
        System.out.println("Node not found" );
    }

        // Optional: Method to display the list
        public void displayList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + "  ");
                current = current.next;
            }
            //System.out.println("null");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("*********************************Welcome to LinkList***************************************");

        System.out.println("Enter the Size of LinkList:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        list.createList(n);

        boolean repeat=true;
        do {

            System.out.println("\n\n Select from the menu");
            System.out.println(" 1. Display Linklist \n 2. Insert at start of Linked List \n 3. Insert at end of Linked List \n 4.Insert at given of Linked List " +
                    "\n 5. Delete first node of Linked List \n 6.Delete Last node of Linked List \n 7.Delete at given of Linked List \n 8.Search \n 0. Exit");

            int case_nos = sc.nextInt();

            switch (case_nos) {
                case 1:
                    System.out.println("\n");
                    System.out.println("Created Linked List:");
                    list.displayList();
                    break;

                case 2:
                    list.insertAtStart();
                    break;

                case 3:
                    list.insertAtEnd();
                    break;

                case 4:
                    System.out.println("Enter position where you wanna enter a node");
                    int pos = sc.nextInt();
                    list.enterAtPos(pos);
                    break;

                case 5:
                    list.deleteList();
                    break;

                case 6:
                    list.deletelastList();
                    break;

                case 7:
                    System.out.println("Enter postion where you wanna delete a node");
                    int pos_del = sc.nextInt();
                    list.deleteAtPos(pos_del);
                    break;

                case 8:
                    System.out.println("Enter data of the node whose position you wanna find");
                    int link_data = sc.nextInt();
                    list.search(link_data);
                    break;

                default:
                    System.out.println("Exiting");
                    return;
            }
        }
        while (repeat!=false);

    }
}
