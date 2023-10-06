import turtle
import random
import colorsys
import math

def dibujar_flor(x, y, escala:1.0):
     

    turtle.speed(0.05)
    turtle.bgcolor("black")

    # Genera los pétalos
    turtle.penup()
    turtle.goto(x, y - 20 * escala)
    turtle.pendown()
    h = 0


















    for i in range(16):
        for j in range(18):
            c = colorsys.hsv_to_rgb(0.125, 1, 1)
            turtle.color(c)
            turtle.rt(90)
            turtle.circle(60 * escala - j * 3 * escala, 90)
            turtle.lt(90)
            turtle.circle(60 * escala - j * 3 * escala, 90)
            turtle.rt(180)
        turtle.circle(20 * escala, 24)

    # Genera la parte central de la flor
    turtle.penup()
    turtle.goto(x, y)
    turtle.pendown()
    turtle.color("black")
    turtle.shape("turtle")
    turtle.fillcolor("brown")
    phi = 137.508 * (math.pi / 180.0)

    
    
    for i in range(200):
        r = 2 * math.sqrt(i)
        theta = i * phi
        x_flor = r * math.cos(theta) * escala + x
        y_flor = r * math.sin(theta) * escala + y
        turtle.penup()
        turtle.goto(x_flor, y_flor)
        turtle.setheading(i * 137.508)
        turtle.pendown()
        turtle.stamp()

# Crear 9 flores de diferentes tamaños en posiciones aleatorias
x = -250
y = 175
for _ in range(2):
    escala = random.uniform(0.8, 2.0)  # Escala aleatoria entre 0.5 y 2.0
    dibujar_flor(x, y, escala)
    x = x + 450

x = -200
y = -175
for _ in range(2):
    escala = random.uniform(0.8, 2.0)  # Escala aleatoria entre 0.5 y 2.0
    dibujar_flor(x, y, escala)
    x = x + 435


x = 0
y = 125
for _ in range(3):
    escala = random.uniform(0.5, 1.3)  # Escala aleatoria entre 0.5 y 2.0
    dibujar_flor(x, y, escala)
    y = y - 250



# Mostrar un mensaje en el centro de la pantalla con colores
turtle.penup()
turtle.goto(0, 0)
turtle.pendown()
turtle.color("yellow")
turtle.write("Te quiero Paty:3", align="center", font=("DejaVu Serif", 24, "italic"))


turtle.done()