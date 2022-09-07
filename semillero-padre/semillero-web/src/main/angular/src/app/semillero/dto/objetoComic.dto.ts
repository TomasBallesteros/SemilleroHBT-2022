import { EstadoEnum } from "../componentes/crear-persona/enums/estado.enum";
import { TematicaEnum } from "../componentes/crear-persona/enums/tematica.enum";

export class ObjetoComicDTO{

    public id : number;

    public nombre : string;

    public editorial : string;

    public tematica : TematicaEnum;

    public numeroPaginas : number;

    public precio : number;

    public autores : string;

    public aColor : boolean;

    public fechaVenta : Date;

    public estado : EstadoEnum;

    constructor(id: number, nombre : string, editorial: string, tematica : TematicaEnum, numeroPaginas : number, precio : number, autores : string, aColor : boolean, fechaVenta : Date, estado : EstadoEnum) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.tematica = tematica;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
        this.autores = autores;
        this.aColor = aColor;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

}