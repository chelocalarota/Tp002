Les dejo una pequeña receta para trabajar con git.

1) Siempre antes de empezar a codear, hacerse un push para traerse lo del repo actualizado:
$ git pull <nombre del branch>

2) Hacer cambios no muy grandes y preparar los cambios para el commit esos cambios:
$ git add <archivos con cambios>

3) Hacer el commit con un mensaje explicativo:
$ git commit -m "<mensaje>"

4) Pushear los commits al branch indicado:
$ git push origin <branch en donde se esta trabajando>
