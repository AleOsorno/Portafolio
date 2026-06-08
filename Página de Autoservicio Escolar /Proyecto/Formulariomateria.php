<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Signika:wght@300..700&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Formulario_inserta_estilo.css">
</head>
<body>
    <div class="container">
        <h2>Insertar materias</h2>
        <form action="action_guardar_materias.php" method="post">
            
            <div class="form-fila">
                <div class="form-grupo">
                    <label>Nombre de la Materia</label>
                    <input type="text" name="nombre_materia" required>
                </div>
                <div class="form-grupo">
                    <label>Clave de la materia</label>
                    <input type="text" name="clave_materia" required>
                </div>
            </div>

            <div class="form-fila">
                <div class="form-grupo">
                    <label>Numero de horas</label>
                    <select name="numero_horas" required>
                        <option value="">Selecciona el numero de horas</option>
                        <option value="48">48</option>
                        <option value="80">80</option>
                    </select>
                </div>
                <div class="form-grupo">
                    <label>Creditos</label>
                    <select name="creditos" required>
                        <option value="">Selecciona los creditos</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                    </select>
                </div>
            </div>

            <div class="form-fila">
                <div class="form-grupo">
                    <label>Semestre</label>
                    <select name="semestre" required>
                        <option value="">Selecciona un semestre</option>
                        <option value="1">Semestre I</option>
                        <option value="2">Semestre II</option>
                        <option value="3">Semestre III</option>
                        <option value="4">Semestre IV</option>
                        <option value="5">Semestre V</option>
                        <option value="6">Semestre VI</option>
                        <option value="7">Semestre VII</option>
                        <option value="8">Semestre VIII</option>
                        <option value="9">Semestre IX</option>
                    </select>
                </div>
                <div class="form-grupo">
                    <label>Materia anterior</label>
                    <select name="materia_anterior" required>
                        <option value="">Selecciona una materia</option>
                        <option value="1">Introduccion a la Computacion</option>
                        <option value="2">Programacion I</option>
                        <option value="3">Programacion II</option>
                        <option value="4">Programacion III</option>
                        <option value="5">Sistemas Operativos</option>
                        <option value="6">Analisis y Diseño de Algoritmos</option>
                        <option value="7">Ingenieria de Software I</option>
                        <option value="8">Lenguajes de Programacion</option>
                        <option value="9">Ingenieria de Software II</option>
                        <option value="10">Base de Datos</option>
                    </select>
                </div>
            </div>
            
            <div class="form-fila">
                <div class="form-grupo">
                    <label>Area</label>
                    <select name="area" required>
                        <option value="">Selecciona una Area</option>
                        <option value="1">Ciencias Básicas</option>
                        <option value="2">Ciencias de la Ingenieria</option>
                        <option value="3">Ciencias de la Ingenieria Aplicada</option>
                        <option value="4">Ciencias Sociales y Humanidades</option>
                        <option value="5">Inglés</option>
                    </select>
                </div>
                <div class="form-grupo">
                <label>Carrera</label>
                    <select name="carrera" required>
                        <option value="">Selecciona una carrera</option>
                        <option value="1">Ingenieria en Tecnologias de la Informacion</option>
                        <option value="2">Ingenieria en Telematica</option>
                        <option value="3">Ingenieria en Tecnologias de Manufactura</option>
                        <option value="4">Ingenieria en Sistemas y Tecnologias Industriales</option>
                        <option value="5">Licenciatura en Administracion y Gestion</option>
                        <option value="6">Licenciatura en Mercadotecnia Internacional</option>
                    </select>
                </div>
            </div>
   
            <button type="submit">Guardar Carrera</button>
        </form>
    </div>
</body>
</html>