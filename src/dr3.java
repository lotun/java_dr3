/**
 * Created by Alex on 25.03.2017.
 */
public class Dr3 implements Car {
    int gruz = 0;
    int height=0;
    int speed=0;
    int type=0;// 0 - легковой, 1 грузовой
    boolean pricep =false;
    boolean special=false;

    public static void main (String args []) throws Exception {
        Dr3 car1 = new Dr3(1,false);
        System.out.println(car1);
        car1.KPP();
    }
    private Dr3(int type,boolean special){
        this.speed = 10 + (int) (Math.random() * 200);//рандом скорости
        this.gruz = 0 + (int) (Math.random() * 100);//рандом грузоподьемности в тоннах
        this.height = 1 + (int) (Math.random() * 7);//рандом высоты
        this.type = type;
        this.special = special;

    }
    public void KPP(){
        String res="";
        int temp=0;
        //если спецтранскорт
        if (this.special) res = "Спец транспорт проехал";
            else {//проверка на все остальное
                try {
                //Проверка скорости на 180
                    if (this.speed>180) throw new Exception("Вызываем ГИБДД");
                //Проверка скорости на 80
                    if (this.speed>80) {
                        temp+=500;
                        throw new Exception("Штраф 500р за превышение скорости");
                    }
                    //проверка на высоту
                    if (height>4) throw new Exception("Машина слишком большая и проехать не может");

                    //если легковой
                    if (this.type==0) res = "Стоимость проезда 1000р";
                    else {
                        //если грузовой без прицепа
                        if (!pricep) {  res = "Стоимость проезда 2000р";  temp += 2000;}
                        //если грузовой с прицепом
                        else {  temp+=500;  res = "Стоимость проезда 2500р";}

                        if (this.gruz>10) { temp += 800; res = "Стоимость проезда " + temp; }
                    }
                }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                //++++++++++++++++++++++++


            }

        System.out.println(res);
    }

    public String toString(){
        return "Скорость: " + this.speed + '\n' + "Грузоподьемность: " + this.gruz + '\n' + "Высота: " + this.height + '\n' + "Тип транскорта: " + this.type + '\n' + "СПризнак спецтранскорта: " + this.special;
    }

    public class MyException extends Exception{
        public MyException(Throwable e) {
            initCause(e);
        }
    }
    //                } catch (Exception e) {
                   // e.printStackTrace();

                    //}
}
