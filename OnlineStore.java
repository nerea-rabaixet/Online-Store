package onlinestore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;

/**
 *
 * @author Hey
 */
public class OnlineStore {
    private LinkedList<User> users; 
    private LinkedList<Item> itemsSold;
    private LinkedList<Item> itemsAvaliable;
    private LinkedList<Package> packages;
    private double totalPrice; // MONEY THAT THE STORE HAS SPENT AQUIRING THE ITEMS TO SOLD
    private double totalProfit; // MONEY EARNED DISCOUNTING WHAT HAS COSTED TO THE STORE TO AQUIRE THE PRODUCTS
    //private Real d;
    
    
    public OnlineStore(){ // HERE WE INITIALIZE THE LINKEDLISTS WITH 0 ELEMENTS
        users = new LinkedList<>();
        itemsSold = new LinkedList<>();
        itemsAvaliable = new LinkedList<>();
        packages = new LinkedList<>();
        totalPrice = 0; 
        totalProfit = 0; 
    }
    
    public boolean addUser (User u){ // BOOLEAN TYPE RETURN INSTEAD OF JUST VOID FOR DEBUGGING PURPOSES
        users.add(u);
        return true; // WILL RETURN TRUE IF THE PROGRAM DOES NOT CRASH IN THE LINE ABOVE
    }
    public boolean rmUser (User u){ 
        users.remove(u);
        return true; 
    }
    private User currentU(){
        User cur = users.get(0);
        users.remove(cur);
        return cur;
    }
    private int usersRemaining(){
        return users.size();
    }
    
    public boolean addItem (Item i){ // THE STORE BUYS AN ITEM
        itemsAvaliable.add(i);
        /*
        double price = 1;
        totalPrice += price;
        */
        return true;
    }
    public boolean rmItem (Item i){ 
        itemsAvaliable.remove(i);
        /* AQUÍ ALGUNA COSA DE VENDRE DE UNA ALTRA FUNCIÓ ON LI PASSEM EL ITEM
        double profit = 1;
        totalProfit += profit;
        */
        itemsSold.add(i);
        return true;
    }
    
    public boolean addPackage (Package p){
        packages.add(p);
        //
        return true;
    }
    public boolean rmPackage (Package p){
        packages.remove(p);
        //
        return true;
    }
    public boolean isPackageinPackages (Package p){
        for(int i = 0; i < packages.size(); i++){
            if (packages.get(i) == p) return true;   
        }
        return false;  
     }
    
    
    void setTotalPrice( double n ){
        totalPrice = n;
    }
    double getTotalPrice(){
        return totalPrice;
    }
   
    void setTotalProfit( double n ){
        totalProfit = n;
    }
    double getTotalProfit(){
        return totalProfit;
    }
    
    private void buy_things(Buyer buyer, Item un){

        int index = 0;
               int length = itemsAvaliable.size();
               while(index < length){
                   Item cur = itemsAvaliable.get(index);
                   if (cur.getName().equals(un.getName())){
                       buyer.buy(un);
                       if (un.getType().equals("unititem")){
                           System.out.println("The person " + buyer.getName() + " has bought " + un.getQuant() + " unit(s) of " + un.getName() + ", that will be delievered in a "+ un.getPackage().getWidth()+ " x " + un.getPackage().getHeight() + " x " + un.getPackage().getDepth() + " package."); 
                       }
                       else{
                           System.out.println("The person " + buyer.getName() + " has bought " + un.getQuant() + " kilos of " + un.getName() + ", that will be delievered in a "+ un.getPackage().getWidth()+ " x " + un.getPackage().getHeight() + " x " + un.getPackage().getDepth() + " package.");
                       }
                      
                       return;
                   }
                   
                   index++;
               }
               if (un.getType().equals("unititem")){
                           System.out.println("The person " + buyer.getName() + " couln't buy " + un.getQuant() + " units of " + un.getName() + " because is out of stock in the shop.");

                }
                else{
                    System.out.println("The person " + buyer.getName() + " couln't buy " + un.getQuant() + " kilos of " + un.getName() + " because is out of stock in the shop.");
                }
    
}
        public void printStockOs(){
            LinkedList<Item> items = itemsAvaliable;
            System.out.println("The online store has now these items in property: ");    
            for(int i=0;i<items.size();i++){
                Item it = items.get(i);
                System.out.println("Name of the item: " + it.getName()+ ", minimum price to retrieve: " + it.getCost());            
            }
        }
    
    
        public boolean addsoldItem(LinkedList <Item>solditems){
                //LinkedList <Item> solditems = seller.getSoldItems();
                int cout = 0;
                int len = solditems.size();
                while(cout < len){
                    itemsAvaliable.add(solditems.get(cout));
                    cout++;
                }
                printStockOs();
                return true;
        }
        public void acctionItem(AuctionItem ai){
            System.out.println("Auction of " + ai.getName() +  " has finished. " + ai.getBuyer().getName() + "has bought the item for" + ai.getPrice() + "euros");
            totalProfit += ai.calculateProfit();
            totalPrice += ai.getCost();
            System.out.println("The totalProfit of the store is: " + totalProfit);
            
            //System.out.println("Auction of " + ai.getName() +  " is still in progress");
            
        }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        OnlineStore os = new OnlineStore();
        
        // ALL 3 ARE EXAMPLES OF UPCAST
        // ADDING SELLER
        double dim_s1[] = {5.0,7.0,3.0};
        UnitItem item_seller_1 = new UnitItem("Mercedes toy", "unititem", dim_s1, 24.95, 20.00, 100);
        double dim_s2[] = {3.0,4.0,3.0};
        UnitItem item_seller_2 = new UnitItem("Ferrarri toy", "unititem", dim_s2, 19.95, 15.00, 300);
        double dim_s3[] = {5.0,4.0,3.0};
        UnitItem item_seller_3 = new UnitItem("Renault toy", "unititem", dim_s3, 19.95, 15.00, 1000);

        LinkedList<Item> miniature_cars = new LinkedList<Item>();
        miniature_cars.add(item_seller_1);
        miniature_cars.add(item_seller_2);
        miniature_cars.add(item_seller_3);

        LinkedList<Item> shirts = new LinkedList<Item>();
        double dim_S1[] = {6,6,2}; //(folded tshirt)
        shirts.add(new WeightedItem("Tshirts", "weighteditem", dim_S1, 24.95, 2, 3600));
       
        os.addUser(new Seller("Marta","103948N","FLorida1","2928371QN",miniature_cars));
        os.addUser(new Seller("Josh","3588589N","Somepass3030","1334958AN",shirts));
        //os.addUser(new Seller("Reimon","2588589N","passivo3030","1634954AN",shirts));
        // ADDING BUYER
        os.addUser(new Buyer("Jordi","23456N","things222","283904QP"));
        // ADDING ADMIN
        os.addUser(new Administrator("Carmen","452919N","UglyCats23"));
        
        
        //
        //while(os.usersRemaining() > 0){
            //seller things
            
            // FIRST 2 ARE SELLERS
            // FIRST SELLER
            System.out.println("///////////// Seller /////////////");
            User u = os.currentU();
            Seller seller = (Seller) u;
            double dim_tobuy_1[] = {5.0,4.0,3.0};
            UnitItem item_tobuy_1 = new UnitItem("Renault toy", "unititem", dim_tobuy_1, 19.95, 15.00, 1000);
            seller.sell(item_tobuy_1);
                                   
            User u2 = os.currentU();
            Seller seller2 = (Seller) u2;
            double dim_tobuy_2[] = {6,6,2};
            WeightedItem item_tobuy_2 = new WeightedItem("Tshirts", "weighteditem", dim_S1, 24.95, 2, 3600);
            seller2.sell(item_tobuy_2);
            
            LinkedList <Item> solditems_1 = seller.getSoldItems();
            LinkedList <Item> solditems2 = seller2.getSoldItems();
            os.addsoldItem(solditems_1);
            os.addsoldItem(solditems2);

            //THEN THERE IS A BUYER
            System.out.println("///////////// Buyer /////////////");
            User u3 = os.currentU();
            Buyer buyer = (Buyer) u3;
            double dim_d[] = {3.0,4.0,5.0};
            
            double dim_un[] = {5.0,4.0,3.0};
            UnitItem un = new UnitItem("Renault toy", "unititem", dim_s3, 19.95, 15.00, 2);
            double dim_un2[] = {3.0,6.0,3.0};
            UnitItem un2 = new UnitItem("Trap songs", "unititem", dim_un2, 2.00, 0.50, 6);
            double dim_un3[] = {6,6,2}; //(folded tshirt)
            WeightedItem un3 = new WeightedItem("Tshirts", "weighteditem", dim_un3, 24.95, 2, 100);
            // if un in avaliitems then buy else dont buy
            os.printStockOs();
            os.buy_things(buyer, un);
            os.printStockOs();
            os.buy_things(buyer, un2);
            os.printStockOs();
            os.buy_things(buyer, un3);
            os.printStockOs();
            
            
            // THEN THERE IS AN ADMIN
            System.out.println("///////////// Administrator /////////////");
            User u4 = os.currentU();
            Administrator admin = (Administrator) u4;
            // WE GIVE THEM SOME USERS THAT WILL BID IN THE AUCTION
            User bidder1 = new Buyer("Manolo","23436N","Fortnite222","283904NP");
            User bidder2 = new Buyer("Pepe","23446N","123456","485804NP");
            LinkedList<User> bidders = new LinkedList<User>();
            bidders.add(bidder1);
            bidders.add(bidder2);
            admin.expel(bidders, bidder1);
            // print bidders and see that manolo is no longer present
            double[] dim_ai = {6.8,6.8,1.0};
            int[] deadline_ai = {28,11,2020};
            AuctionItem ai = new AuctionItem("Painting","Art",dim_ai,150.00,120.00,deadline_ai);
            double[] dim_ai2 = {4.0,4.0,4.0};
            int[] deadline_ai2 = {15,10,2020};
            AuctionItem ai2 = new AuctionItem("Rare chandelier","Museum things",dim_ai2,250.00,200.00,deadline_ai2);
            
            
            ai.makeBid((Buyer)bidder1,140.0);
            ai.makeBid((Buyer)bidder2,180.00);
            
            ai2.makeBid((Buyer)bidder1,260.0);
            ai2.makeBid((Buyer)bidder2,300.00);
           
            
            
            int current_date[] = {24,11,2020};
            if (admin.manageAuction(ai, current_date)){
                os.acctionItem(ai);
            }
            else{
                System.out.println("Auction of " + ai.getName() +  " is still in progress");
            }
            
            if (admin.manageAuction(ai2, current_date)){
                os.acctionItem(ai2);
            }
            else{
                System.out.println("Auction of " + ai2.getName() +  " is still in progress");
            }
           
            LinkedList<AuctionItem> items_to_auction = new LinkedList<AuctionItem>(); 
            items_to_auction.add(ai);
            items_to_auction.add(ai2);
                        
            admin.printStock(items_to_auction);
        }
    }