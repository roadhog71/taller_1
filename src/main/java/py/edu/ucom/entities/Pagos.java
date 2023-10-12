package py.edu.ucom.entities;

import java.util.List;

public class Pagos {
        public List<Productos> productosComprados;

        public List<Productos> getLibrosPrestados() {
            return this.productosComprados;
        }
        public void listproductosComprados(List<Productos> productosComprados) {
            this.productosComprados = productosComprados;
        }
}
