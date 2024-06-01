program parial;
const
    valoralto = 9999;
type
    partido = record
        equipo_cod, anio, torneo_cod, rival_cod, goles_favor, goles_contra, puntos: integer;
        nombre: string;
    end;

     AR = file of partido;

procedure leer (var archivo: AR; var reg: partido);
begin
    if (not eof(archivo)) then 
        read(archivo, reg);
    else
        reg.anio := valoralto;
end;


procedure informe (var archivo: AR);
var
    reg, aux: partido,
    TOTAL_goles_favor, TOTAL_goles_contra, TOTAL_ganados, TOTAL_perdidos, TOTAL_empatados, TOTAL_puntos: integer;
    anio_act, torneo_act, equipo_act: integer;
    nombre_ganador: string;
    max: integer;
begin
    reset (archivo);
    leer (archivo, reg);

    while (reg.anio <> valoralto) do begin
        anio_act := reg.anio; writeln ('Ano: ', reg.anio);
        
        while (reg.anio <> valoralto) AND (reg.anio = anio_act) do begin
            torneo_act := reg.torneo_cod; writeln ('Cod_torneo: ', reg.torneo_cod);
            max := -1;

            while (reg.anio <> valoralto) AND (reg.anio = anio_act) AND (reg.torneo_cod = torneo_act) do begin
                equipo_act := reg.equipo_cod; writeln ('Cod_equipo: ', reg.equipo_cod);
                TOTAL_goles_favor := 0; TOTAL_goles_contra := 0; TOTAL_ganados := 0; TOTAL_perdidos := 0; TOTAL_empatados := 0; TOTAL_puntos := 0;

                while (reg.anio <> valoralto) AND (reg.anio = anio_act) AND (reg.torneo_cod = torneo_act) AND (reg.equipo_cod = equipo_act) do begin
                    TOTAL_goles_favor := TOTAL_goles_favor + reg.goles_favor;
                    TOTAL_goles_contra := TOTAL_goles_contra + reg.goles_contra;
                    TOTAL_puntos := TOTAL_puntos + reg.puntos;

                    if (reg.puntos = 0) then begin
                        TOTAL_perdidos := TOTAL_perdidos + 1;
                        else if (reg.puntos = 1) then 
                            TOTAL_empatados := TOTAL_empatados + 1;
                            else
                                TOTAL_ganados := TOTAL_ganados + 1;
                    end;
                    
                    aux := reg; // guarda registro anterior para el ganador del torneo
                    leer (archivo, reg);
                end;
                writeln ('Cantidad total de goles a favor equipo ', equipo_act, ': ', TOTAL_goles_favor);
                writeln ('Cantidad total de goles en contra equipo ', equipo_act, ': ', TOTAL_goles_contra);
                writeln ('Diferencia de goles: '); writeln (TOTAL_goles_favor - TOTAL_goles_contra);
                writeln ('Cantidad de partidos ganados equipo ', equipo_act, ': ', TOTAL_ganados);
                writeln ('Cantidad de partidos empatados equipo ', equipo_act, ': ', TOTAL_empatados);
                writeln ('Cantidad de partidos perdidos equipo ', equipo_act, ': ', TOTAL_perdidos);
                writeln ('Cantidad total de puntos equipo ', equipo_act, ': ', TOTAL_puntos);

                if (TOTAL_puntos > max) then begin
                    max := TOTAL_puntos;
                    nombre_ganador := aux.nombre;
                end;
            end;
            writeln ('El equipo', nombre_ganador, ' fue campeon del torneo', torneo_act, ' del ano', anio_act);
        end;
    end;

    close (archivo);
end.



