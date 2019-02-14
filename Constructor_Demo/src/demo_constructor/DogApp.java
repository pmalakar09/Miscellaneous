package demo_constructor;

class Dog{
    private String name;
    private String breed;
    private int cost;
    public Dog (String name, String breed, int cost)
    {
        this.name=name;
        this.breed=breed;
        this.cost=cost;
    }
   public Dog() {
		// TODO Auto-generated constructor stub
	}

String getName()
{
    return name;
}
String getBreed()
{
    return breed;
}
int getCost()
{
    return cost;
}

}
class DogApp{
    public static void main(String[] args) {
    
        Dog d=new Dog("TOMY","BULLDOG" ,5);
        System.out.println(d.getName());
        System.out.println(d.getBreed());
        System.out.println(d.getCost());
        Dog d1=new Dog();
        System.out.println(d1.getName());
        System.out.println(d1.getBreed());
        System.out.println(d1.getCost());
}
}