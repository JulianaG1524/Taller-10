package uniandes.dpoo.taller1.modelo;

/**
 * Esta clase agrupa la informaciÃ³n sobre un libro disponible en la librerÃ­a
 */
public class Libro
{

	// ************************************************************************
	// Atributos
	// ************************************************************************

	/**
	 * TÃ­tulo del libro
	 */
	private String titulo;

	/**
	 * Autor o autores del libro
	 */
	private String autor;

	/**
	 * CalificaciÃ³n obtenida por el libro en el sitio bookdepository.com
	 */
	private double calificacion;

	/**
	 * CategorÃ­a a la que pertenece el libro
	 */
	private Categoria categoria;

	/**
	 * Imagen con la portada del libro
	 */

	private Imagen portada;
	// ************************************************************************
	// Constructores
	// ************************************************************************

	/**
	 * Construye un nuevo libro, sin portada, a partir de los parÃ¡metros.
	 * 
	 * La portada se inicializa en null.
	 * 
	 * AdemÃ¡s de inicializar los atributos del libro, agrega el libro que se estÃ¡
	 * creando a la categorÃ­a usando el mÃ©todo agregarLibro de la clase CategorÃ­a.
	 * 
	 * @param elTitulo       TÃ­tulo del libro
	 * @param elAutor        Autor o autores del libro
	 * @param laCalificacion CalificaciÃ³n obtenida por el libro en
	 *                       bookdepository.com
	 * @param laCategoria    CategorÃ­a a la que pertenece el libro
	 */
	public Libro(String elTitulo, String elAutor, double laCalificacion, Categoria laCategoria)
	{
		titulo = elTitulo;
		autor = elAutor;
		calificacion = laCalificacion;
		categoria = laCategoria;
		categoria.agregarLibro(this);
	}

	// ************************************************************************
	// MÃ©todos para consultar los atributos
	// ************************************************************************

	/**
	 * Consulta el tÃ­tulo del libro
	 * 
	 * @return titulo
	 */
	public String darTitulo()
	{
		return titulo;
	}

	/**
	 * Consulta el autor del libro
	 * 
	 * @return autor
	 */
	public String darAutor()
	{
		return autor;
	}

	/**
	 * Consulta la calificaciÃ³n del libro en bookdepository.com
	 * 
	 * @return calificacion
	 */
	public double darCalificacion()
	{
		return calificacion;
	}

	/**
	 * Consulta la categorÃ­a del libro
	 * 
	 * @return categoria
	 */
	public Categoria darCategoria()
	{
		return categoria;
	}

	/**
	 * Consulta la imagen con la portada del libro. Si el libro no tiene una portada
	 * debe retornar la imagen por defecto de 85x85 pixeles que se encuentra en el
	 * archivo "./data/imagenes/missing.png"
	 * 
	 * @return La portada del libro o un objeto de tipo Imagen con la imagen del
	 *         archivo "./data/imagenes/missing.png"
	 */
	public Imagen darPortada()
	{
		Imagen resul;
		if (this.tienePortada()) {
			resul = portada;
		} else {
			resul = new Imagen("./imagenes/missing.png",85,85);
		}
		return resul;
	}

	// ************************************************************************
	// Otros mÃ©todos
	// ************************************************************************

	/**
	 * Modifica la portada del libro
	 * 
	 * @param nuevaPortada Nueva portada para el libro
	 */
	public void cambiarPortada(Imagen nuevaPortada)
	{
		portada = nuevaPortada;
	}

	/**
	 * Permite saber si este libro tiene portada.
	 * 
	 * @return Retorna true si el libro tiene una portada. Retorna false en caso
	 *         contrario.
	 */
	public boolean tienePortada()
	{
		if (this.portada == null) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return titulo + " (" + autor + ")";
	}
}
