/**
 * Created by Alex on 25.03.2017.
 */
public class dr3 implements car {
    int gruz = 0;
    int height=0;
    int speed=0;
    int type;
    boolean special=false;

    public static void main (String args []) {
        dr3 car1 = new dr3(1,false);
        System.out.println(car1);
        car1.KPP();
    }
    private dr3(int type,boolean special){
        this.speed =  10 + (int) (Math.random() * 200);//рандом скорости
        this.gruz = 0 + (int) (Math.random() * 100);//рандом грузоподьемности в тоннах
        this.height = 1 + (int) (Math.random() * 7);//рандом высоты
        this.type = type;
        this.special = special;

    }
    public void KPP(){
        String res;
        int temp=0;
        //если спецтранскорт
        try {
            if (this.speed>180)
                throw new Exception("Вызываем ГИБДД");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.speed>80)
                throw new Exception("Штраф 500р за превышение скорости");
        } catch (Exception e) {
            e.printStackTrace();
            temp+=500;
        }
        if (this.special==true) res = "Спец транспорт проехал";
            else {
                //если легковой
                if (this.type==0) res = "Стоимость проезда 1000р";
                else {
                    //если грузовой без прицепа
                    if (pricep==false) {  res = "Стоимость проезда 2000р";  temp += 2000;}
                    //если грузовой с прицепом
                    else {  temp+=500;  res = "Стоимость проезда 2500р";}
                    try {
                        if (height>4)
                            throw new Exception("Машина слишком большая и проехать не может");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (this.gruz>10) { temp += 800; res = "Стоимость проезда " + temp; }
                }
            }

        System.out.println(res);
    }

    public String toString(){
        return "Скорость: " + this.speed + '\n' + "Грузоподьемность: " + this.gruz + '\n' + "Высота: " + this.height + '\n' + "Тип транскорта: " + this.type + '\n' + "СПризнак спецтранскорта: " + this.special;
    }

}
