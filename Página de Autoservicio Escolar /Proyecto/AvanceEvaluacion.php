<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Avance de Evaluación</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Roboto Slab', serif;
            background-color: #242424;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            width: 95%;
            max-width: 1200px;
            background-color: #353535;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            color: white;
        }

        h1 {
            font-size: 24px;
            color: #ffffff;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            max-height: 400px;
            border-collapse: collapse;
            margin-bottom: 20px;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.61);
            color: white;
            display: block;
            overflow-y: auto;
        }

        thead, tbody {
            display: table;
            width: 100%;
            table-layout: fixed;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #080808;
        }

        th {
            background-color: orangered; 
            color: white;
            text-transform: uppercase;
            font-size: 13px;
        }

        tr:hover {
            transition: all 0.5s;
            background-color: black;
        }

        .button-container {
            display: flex;
            justify-content: center;
            gap: 10px;
        }

        a {
            padding: 10px 20px;
            margin: 10px;
            border: none;
            background-color: orangered;
            color: white;
            cursor: pointer;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            font-weight: bold;
            width: 150px;
            text-align: center;
            transition: all 0.5s;
        }

        a:hover {
            background-color: rgb(196, 52, 0);
        }

        @media (max-width: 768px) {
            .container {
                width: 100%;
                padding: 10px;
            }

            table {
                font-size: 13px;
            }
        }

        table::-webkit-scrollbar {
            display: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Avance Estadístico de Evaluación</h1>
        <?php
        $var_profe = $_COOKIE['matri']; // Matrícula del profesor desde la cookie

        // Conexión a la base de datos
        $server = 'localhost';
        $user = 'root';
        $pass = '';
        $database = 'mysql';
        $link = mysqli_connect($server, $user, $pass, $database);
        mysqli_set_charset($link, "utf8");

        if (!$link) { header("Location: Login.php"); exit(); }

        $database = 't15a_proyecto';
        mysqli_select_db($link, $database);

        $cadQuery = "SELECT grupos.clave_grupo, grupos.grupo, materias.nombre_materia, horarios.hora_lunes, horarios.tipo FROM grupos
        INNER JOIN materias ON grupos.materia = materias.materia
        INNER JOIN horarios ON grupos.horario = horarios.horario
        WHERE maestro = $var_profe";
        $result = $link->query($cadQuery);

        if ($result->num_rows > 0) {
            echo "<table>";
            echo "<thead>
                    <tr>
                        <th>Clave del Grupo</th>
                        <th>Nombre de la materia</th>
                        <th>Total Alumnos</th>
                        <th>U1 Evaluados</th>
                        <th>U2 Evaluados</th>
                        <th>U3 Evaluados</th>
                        <th>U. Final Eval.</th>
                        <th>Extraordinario</th>
                    </tr>
                  </thead>";
            echo "<tbody>";
            
            while ($row = $result->fetch_assoc()) {
                $grupo = $row['grupo'];
                $total_alumnos_2 = 0;
                
                // Conteo de alumnos en el grupo
                $query_2 = "SELECT calificaciones.alumno FROM calificaciones
                            INNER JOIN usuarios ON calificaciones.alumno = usuarios.matricula
                            WHERE calificaciones.grupo = $grupo AND usuarios.tipo = 1;"; 
                $alumnos = $link->query($query_2);

                if($alumnos->num_rows > 0){
                    while ($fila = $alumnos->fetch_assoc()) {
                        $total_alumnos_2++;
                    }
                }

                // Conteo Unidad 1
                $query_3 = "SELECT COUNT(*) AS total FROM calificaciones
                            INNER JOIN usuarios ON calificaciones.alumno = usuarios.matricula
                            WHERE calificaciones.grupo = $grupo AND usuarios.tipo = 1 AND calificaciones.u1 IS NOT NULL;";
                $res3 = $link->query($query_3);
                $p = ($res3) ? $res3->fetch_assoc()['total'] : 0;

                // Conteo Unidad 2
                $query_4 = "SELECT COUNT(*) AS total FROM calificaciones
                            INNER JOIN usuarios ON calificaciones.alumno = usuarios.matricula
                            WHERE calificaciones.grupo = $grupo AND usuarios.tipo = 1 AND calificaciones.u2 IS NOT NULL;";
                $res4 = $link->query($query_4);
                $o = ($res4) ? $res4->fetch_assoc()['total'] : 0;

                // Conteo Unidad 3
                $query_5 = "SELECT COUNT(*) AS total FROM calificaciones
                            INNER JOIN usuarios ON calificaciones.alumno = usuarios.matricula
                            WHERE calificaciones.grupo = $grupo AND usuarios.tipo = 1 AND calificaciones.u3 IS NOT NULL;";
                $res5 = $link->query($query_5);
                $k = ($res5) ? $res5->fetch_assoc()['total'] : 0;

                // Conteo Unidad Final
                $query_6 = "SELECT COUNT(*) AS total FROM calificaciones
                            INNER JOIN usuarios ON calificaciones.alumno = usuarios.matricula
                            WHERE calificaciones.grupo = $grupo AND usuarios.tipo = 1 AND calificaciones.uf IS NOT NULL;";
                $res6 = $link->query($query_6);
                $h = ($res6) ? $res6->fetch_assoc()['total'] : 0;

                // Conteo Extraordinario
                $query_7 = "SELECT COUNT(*) AS total FROM calificaciones
                            INNER JOIN usuarios ON calificaciones.alumno = usuarios.matricula
                            WHERE calificaciones.grupo = $grupo AND usuarios.tipo = 1 AND calificaciones.ee IS NOT NULL;";
                $res7 = $link->query($query_7);
                $e = ($res7) ? $res7->fetch_assoc()['total'] : 0;

                echo "<tr>
                        <td>" . htmlspecialchars($row["clave_grupo"]) . "</td>
                        <td>" . htmlspecialchars($row["nombre_materia"]) . "</td>
                        <td>" . $total_alumnos_2 . "</td>
                        <td>" . $p . "</td>
                        <td>" . $o . "</td>
                        <td>" . $k . "</td>
                        <td>" . $h . "</td>
                        <td>" . $e . "</td>
                      </tr>";
            }
            echo "</tbody>";
            echo "</table>";
            echo "<div class='button-container'>";
            echo "<a href='Menu.php'>Salir</a>";
            echo "</div>";
        } else {
            echo "<p>No se encontraron grupos asignados.</p>";
            echo "<div class='button-container'>";
            echo "<a href='Menu.php'>Salir</a>";
            echo "</div>";
        }
        ?>
    </div>
</body>
</html>