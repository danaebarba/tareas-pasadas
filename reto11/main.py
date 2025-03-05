import math

# Variables de entrada:
# Números dados por el usuario
x1, x2 = 0, 0
factorial = 1
# Números para el fibonacci
num1, num2, suma = 0, 1, 1
# variables de salida:
# La respuesta para el usuario
respuesta = 0
# La operacion para el usuario
operacion = "x"
# pedir al usuario que elija una operación
print("Elige una opción de operación:")
print("1. suma")
print("2. resta")
print("3. multiplicación")
print("4. división")
print("5. módulo/resto")
print("6. logaritmo")
print("7. factorial")
print("8. fibonacci")
# El usuario introduce su elección
choice = int(input())
# pedir al usuario de un número si es factorial o fibonacci
if choice == 7 or choice == 8:
    print("Dame un número entero")
    # El usuario introduce el numero
    x1 = int(input())
# Pedirle al usuario dos números si es cualquier otra operación
elif choice < 7 or choice > 0:
    print("Dame un número entero")
    # El usuario introduce el numero
    x1 = int(input())
    print("Dame otro número entero")
    # El usuario introduce el numero
    x2 = int(input())
# Si el usuario escoge suma se hace la operación de suma
if choice == 1:
    # calcular la operación escogida
    respuesta = x1 + x2
    operacion = "+"
    # imprimir resultados
    print(f"Tu operación es: {x1} {operacion} {x2} = {respuesta}")
# Si el usuario escoge resta se hace la operación de resta
elif choice == 2:
    # calcular la operación escogida
    respuesta = x1 - x2
    operacion = "-"
    # imprimir resultados
    print(f"Tu operación es: {x1} {operacion} {x2} = {respuesta}")
# Si el usuario escoge multiplicación se hace la operación de multiplicación
elif choice == 3:
    # calcular la operación escogida
    respuesta = x1 * x2
    operacion = "*"
    # imprimir resultados
    print(f"Tu operación es: {x1} {operacion} {x2} = {respuesta}")
# Si el usuario escoge division se hace la operación de division
elif choice == 4:
    # Si el usuario escogio 0 como divisor, se le avisa que no puede poner eso.
    if x2 == 0:
        print("No puedes poner 0 como divisor")
    else:
        # calcular la operación escogida
        respuesta = x1 / x2
        operacion = "/"
        # imprimir resultados
        print(f"Tu operación es: {x1} {operacion} {x2} = {respuesta}")
# Si el usuario escoge módulo/resto se hace la operación de módulo/resto
elif choice == 5:
    # calcular la operación escogida
    respuesta = x1 % x2
    operacion = "%"
    # imprimir resultados
    print(f"Tu operación es: {x1} {operacion} {x2} = {respuesta}")
# Si el usuario escoge logaritmo se hace la operación de logaritmo
elif choice == 6:
    # calcular la operación escogida
    respuesta = (math.log(x1) / math.log(x2))
    # imprimir resultados
    print(f"El logaritmo {x1} con base {x2} es {respuesta}")
# Si el usuario escoge factorial se hace la operación de factorial
elif choice == 7:
    # calcular la operación escogida
    for i in range(1, x1+1):
        factorial *= i
    # imprimir resultados
    print(f"El factorial de {x1} es: {factorial}")
# Si el usuario escoge fibonacci se hace la operación de fibonacci
elif choice == 8:
    # calcular la operación escogida
    for i in range(1, x1):
        # imprimir resultados
        print(suma, end=", ")
        suma = num1 + num2
        num1 = num2
        num2 = suma