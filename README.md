# Ejemplo de uso de Android ARCore.


ARCore es un kit de desarollo creado por Google que nos permite crear aplicaciones con realidad aumentada,  ARCore utiliza tres tecnologías clave para integrar contenido virtual con el mundo real en el cual se ve atraves de la camara de tu telefono:

1. Seguimiento de movimiento en el cual el smartphone rastree y comprenda su posicion en el mundo.
2. Compresión ambiental en el cual el smartphone detecte la ubicación y tamaño de superficies planas.
3. Estimación de la cantidad de luz para las condiciones del entorno.



En la imagenes siguientes se muestra el ejemplo corriendo en android:



Para la modificacion de la rotacion en la clase ArNode en el metodo setImage (node.setLocalRotation(new Quaternion(pose.qx(), pose.qy(), pose.qz(), pose.qw()));)


pose.qz() + 0.4f


![](android/app/src/main/assets/qz.jpg)


pose.qy() + 0.4f


![](android/app/src/main/assets/qy.jpg)


pose.qx() - 0.5f


![](android/app/src/main/assets/qx.jpg)

