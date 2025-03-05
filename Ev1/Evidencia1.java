/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evidencia1;

/**
 *
 * @author danae
 */
public class Evidencia1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //Variable del semaforo de abajo
       boolean trafficLightOut = false;
       //Se crean todas las filas con sus limites de tamaño.
       Queue f1 = new Queue(48); 
       Queue f2 = new Queue(15); 
       Queue f3 = new Queue(15); 
       Queue f4 = new Queue(10);
       Queue f5 = new Queue(40); 
       Queue f6 = new Queue(40); 
       Queue f7 = new Queue(16); 
       Queue f8 = new Queue(15); 
       Queue f9 = new Queue(16); 
       Queue f10 = new Queue(16); 
       Queue f11 = new Queue(32); 
       //Se crean los nodos de prioridad, que seran las filas en el semaforo de en medio
       //Con sus diferentes prioridas y en estos se encuentran los datos de las filas.
       PriorityNode pn1 = new PriorityNode(1, f1, 1);
       PriorityNode pn3 = new PriorityNode(2, f3, 3);
       PriorityNode pn6 = new PriorityNode(3, f6, 6);
       PriorityNode pn9 = new PriorityNode(4, f9, 6);
       
       //Se crea una lista de prioridad.
       PriorityQueue trafficLights = new PriorityQueue();
       //En estas filas se agregan los nodos de prioridad de las filas del semaforo.
       trafficLights.push(pn1);
       trafficLights.push(pn3);
       trafficLights.push(pn6);
       trafficLights.push(pn9);
       
       //Ese ciclo se repetira hasta que el jugador decida pausarlo.
       while(true){
           //Try catch por si alguna lista llega a vaciarse.
           try{
               //Se crea la variable de carro.
            Car car;
            //Si la fila 1 no esta llena se le agregan 3 carros.
            if(!f1.isFull()){
                car = new Car();
                f1.push(car);
                car = new Car();
                f1.push(car);
                car = new Car();
                f1.push(car);
            }
            //Si la fila 3 no esta llena se le agregan 3 carros.
            if(!f3.isFull()){
                car = new Car();
                f3.push(car);
                car = new Car();
                f3.push(car);
                car = new Car();
                f3.push(car);
            }
            //Si la fila 6 no esta llena se le agregan 3 carros.
            if(!f6.isFull()){
                car = new Car();
                f6.push(car);
                car = new Car();
                f6.push(car);
                car = new Car();
                f6.push(car);
            }
            //Se imprimen los carros que se encuentran en cada fila.
            System.out.println("Fila 1: " + f1);
            System.out.println("Fila 3: " + f3);
            System.out.println("Fila 6: " + f6);
            //Validar que semaforo esté en verde, y que la fila 11 no este vacía
            //si está en verde entonces pop F11
            if(trafficLightOut = true && !f11.isEmpty()){
                //Se sacan 3 carros de la lista por semaforo.
                do{
                    for(int i = 0; i<5; i++){
                        f11.pop();
                    }
                }while(!f11.isEmpty());
                //Si despues de sacar los carros la lista no queda vacía 
                //se imprime lo que contiene.
                if(!f11.isEmpty()){
                        System.out.println("Fila 11: " + f11);
                }if(f11.isEmpty()){
                    //Si se vacía, se imprime que la fila 11 quedo vacía.
                    System.out.println("La fila 11 se ha vacíado");
                }
            }
            //Validar que F11 tenga espacio
            if(!f11.isFull()){
                //Si F10 esta vacío then check size F8
                if(f10.isEmpty()){
                    //Si F8 no esta vacio then pop y mover a F11
                    if(!f8.isEmpty()){
                        do{
                            //Se mueven 2 carros en esta accion.
                            for(int i = 0; i<2; i++){
                                Car currentCar = (Car)f8.pop();
                                f11.push(currentCar);
                            }
                        }while(!f8.isEmpty() && !f11.isFull());
                        //Se imprime como queda la fila 11.
                        System.out.println("Fila 11: " + f11);
                    }
                }else{
                    //Si la fila 10 no esta vacia, se mueven todos los elementos a la fila 11.
                    for(int i = 0; i<f11.size(); i++){
                        if(!f11.isFull()){
                            Car currentCar = (Car)f10.pop();
                            f11.push(currentCar);
                        }else{
                            break;
                        }
                    }
                    //Se imprime lo que se encuentra en la fila 11.
                    System.out.println("Fila 11: " + f11);
                }
            }
            //Definir prioridades y rotarlas.
            PriorityNode currentPriorityNode = (PriorityNode)trafficLights.pop();
            currentPriorityNode.setPriority(trafficLights.peek().getPriority() + 1);
            trafficLights.push(currentPriorityNode);
            Queue currentQueue = (Queue)currentPriorityNode.getData();
            //Repetir de adelante para atrás.
            //Sacar un numero random, que sera la probabilidad de que vayan a las
            //diferentes salidas de la fila 9
            int Probability = (int) (Math.floor(Math.random()*(100)));
            //Si la probabilidad es mayor a 50, menor a 67, la fila dos no esta 
            //llena y el semaforo esta verde para la fila 9.
            if(Probability > 50 && Probability < 67 && !f2.isFull() && currentQueue == f9){
                //Se le avisa al usuario que tres carros se fueron de la fila 9 a la fila 2
                System.out.println("Un carro de la fila 9 se fue a la fila 2");
                //Si la fila 9 no esta vacia se sale un carro y se lleva a la fila 2
                //de ahi, sale directamente ya que este no cuenta con semaforo.
                if(!f9.isEmpty()){
                    Car currentCar = (Car)f9.pop();
                    f2.push(currentCar);
                    f2.pop();
                }
            }
            //Si la probabilidad es mayor a 67, menor a 83, la fila cuatro no esta 
            //llena y el semaforo esta verde para la fila 9.
            if(Probability > 67 && Probability < 83 && !f4.isFull() && currentQueue == f9){
                //Se le avisa al usuario que tres carros se fueron de la fila 9 a la fila 4
                System.out.println("Un carro de la fila 9 se fue a la fila 4");
                //Si la fila 9 no esta vacia se sale un carro y se lleva a la fila 4
                //de ahi, sale directamente ya que este no cuenta con semaforo.
                if(!f9.isEmpty()){
                    Car currentCar = (Car)f9.pop();
                    f4.push(currentCar);
                    f4.pop();
                }
            }
            //Si la probabilidad es mayor a 83, menor a 100, la fila 5 no esta 
            //llena y el semaforo esta verde para la fila 9.
            if(Probability > 83 && Probability < 101 && !f5.isFull() && currentQueue == f9){
                //Se le avisa al usuario que tres carros se fueron de la fila 9 a la fila 5
                System.out.println("Un carro de la fila 9 se fue a la fila 5");
                //Si la fila 9 no esta vacia se sale un carro y se lleva a la fila 5
                //de ahi, sale directamente ya que este no cuenta con semaforo.
                if(!f9.isEmpty()){
                    Car currentCar = (Car)f9.pop();
                    f5.push(currentCar);
                    f5.pop();
                }
            }
            //Si el semaforo esta verde para la fila 9, la fila 9 no esta vacía 
            //y la fila 10 no esta llena.
            if(currentQueue == f9 && !f10.isFull() && !f9.isEmpty()){
                //Si la fila 11 no esta llena se pasan 5 carros máximo de la fila 9.
                if(!f11.isFull()){
                    do{
                        for(int i = 0; i<5; i++){
                            Car currentCar = (Car)f9.pop();
                            f11.push(currentCar);
                        }
                    }while(!f9.isEmpty() && !f10.isFull());
                    //Se imprime lo que quede en la fila 11.
                    System.out.println("Fila 11: " + f11);
                }else{
                    //Si la fila 11 esta llena, se pasan los carros a la fila 10
                    //mientras la fila 9 no este vacía
                    do{
                        for(int i = 0; i<2; i++){
                            Car currentCar = (Car)f9.pop();
                            f10.push(currentCar);
                        }
                    }while(!f9.isEmpty() && !f10.isFull());
                    //Se imprime lo que esta en la fila 10.
                    System.out.println("Fila 10: " + f10);
                }
            }
            //Si la fila 9 esta llena, la fila 7 no esta vacia y la fila 8 no esta llena.
            if(f9.isFull() && !f8.isFull() && !f7.isEmpty()){
                //Salen 4 carros de la fila 7 a la fila 8, mientras la fila 7 
                //no se vacíe.
                do{
                    for(int i = 0; i<4; i++){
                        Car currentCar = (Car)f7.pop();
                        f8.push(currentCar);
                    }
                }while(!f7.isEmpty() && !f8.isFull());
                //Se imprime lo que quede en la fila 8.
                System.out.println("Fila 8: " + f8);
            }if(!f9.isFull() && !f7.isEmpty()){
                //Si la fila 9 no esta llena y la fila 7 no esta vacía se 
                //moveran maximo 5 carros a la fila 9
                do{
                    for(int i = 0; i<5; i++){
                        Car currentCar = (Car)f7.pop();
                        f9.push(currentCar);
                    }
                }while(!f7.isEmpty() && !f9.isFull());
                //Se imprime la fila 9.
                System.out.println("Fila 9: " + f9);
            }
            //Si la fila 7 no esta llena y la fila que tenga semaforo verde
            //no esta vacía.
             if(!f7.isFull() && !currentQueue.isEmpty()){
                 //Se moveran de esta fila a la fila 7 máximo 7 carros.
                 do{
                     for(int i = 0; i<3; i++){
                         //Sacar el carro de la cola priorizada
                         Car currentCar = (Car)currentQueue.pop();
                         //Meter el carro a la cola 7
                         f7.push(currentCar);
                     }
                //Mientras la fila 7 no se llene y la fila actual no este vacía.
                 }while(!f7.isFull() && !currentQueue.isEmpty());
                 System.out.println("Fila 7: " + f7);
             }
             //Imprimir todas las filas que quedan y sus datos.
            System.out.println("Fila 1: " + f1);
            System.out.println("Fila 3: " + f3);
            System.out.println("Fila 6: " + f6);
            //semaforo = !semaforo
            trafficLightOut = !trafficLightOut;
            System.out.println("Cambio de semáforo a fila " + currentPriorityNode.getNum_Fila());
            //Definir un sleep para que no vaya tan rápido y sea posible leer.
             Thread.sleep(5000);
             //Exception para que te marque si alguna lista queda vacía.
           }catch(Exception e){
               System.out.println("La lista esta vacía.");
           }
       }
    }
}
