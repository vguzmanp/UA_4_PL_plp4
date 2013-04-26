
import java.util.ArrayList;



/**
 *
 * @author victor
 */
public class Tipo {
    
    tipoLiteral tipo;
    int dimension;
    Tipo tipobase;
    boolean array;
    boolean indice;
    
    public Tipo(tipoLiteral _tipo){

        tipo = _tipo;
        dimension = 0;
        tipobase = null;
        array = false;
        indice = false;
		
    }
    
    public Tipo(tipoLiteral _tipo, boolean _indice){
        tipo = _tipo;
        dimension = 0;
        tipobase = null;
        indice = true;
    }
    
    
    public Tipo(tipoLiteral _tipo, Tipo _tipobase){
        tipo = tipoLiteral.array;
        dimension = -1;
        tipobase = _tipobase;
        array = true;
    }
    
    public Tipo(Tipo _anterior){
        tipo = _anterior.tipo;
        dimension = _anterior.dimension;
        tipobase = _anterior.tipobase;
    }
    
    public tipoLiteral getTipo(){
		return tipo;
	} 
	
	public boolean isIndice(){
		return indice;
	}

	public boolean esArray(){
		if(tipo == tipoLiteral.array)
			return true;
		else
			return false;
	}
	
    public Tipo getTipoBase(){
		return tipobase;
	}
	
	public tipoLiteral getTipoFinal(){
		if(array){
			return tipobase.getTipoFinal();
		} else{
			return tipo;
		}
	}
	
    public int getDimension(){
		return dimension;
	}
	
    public int getDimensionTotal(){
		if(array){
			return dimension*tipobase.getDimensionTotal();
		}else{
			return 1;
		}
	}
	
    public void setDimension(int _dim) throws Error_8{
		if(_dim > 0){
			dimension = _dim;
		}else{
			throw new Error_8(0,0);
		}
	}
    public void setDimension(String _dim) throws Error_8{
		setDimension(Integer.parseInt(_dim));
	}
	
	@Override
	public String toString(){
		if (array){
			return tipobase.toStringSoloTipo() + "[]";
			//return "[] -> " + tipobase.toString();
		}else{
			return tipo.toString();
		}
		
	}
	
	private String toStringSoloTipo(){
		if (array){
			return tipobase.toStringSoloTipo();
		}else{
			return tipo.toString();
		}
		
	}
	
}
