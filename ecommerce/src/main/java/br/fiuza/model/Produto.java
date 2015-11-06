package br.fiuza.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import br.fiuza.model.Fabricante;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;

@Entity
@XmlRootElement
public class Produto implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column
   private String Nome;

   @Column
   private Double precoVenda;

   @Column
   private int estoque;

   @Column
   private Double precoCusto;

   @Column
   private Double MargemLucro;

   @OneToMany
   private Set<Fabricante> fabricante = new HashSet<Fabricante>();

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof Produto))
      {
         return false;
      }
      Produto other = (Produto) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public String getNome()
   {
      return Nome;
   }

   public void setNome(String Nome)
   {
      this.Nome = Nome;
   }

   public Double getPreco()
   {
      return precoVenda;
   }

   public void setPreco(Double preco)
   {
      this.precoVenda = preco;
   }

   public int getEstoque()
   {
      return estoque;
   }

   public void setEstoque(int estoque)
   {
      this.estoque = estoque;
   }

   public Double getPrecoCusto()
   {
      return precoCusto;
   }

   public void setPrecoCusto(Double precoCusto)
   {
      this.precoCusto = precoCusto;
   }

   public Double getMargemLucro()
   {
      return MargemLucro;
   }

   public void setMargemLucro(Double MargemLucro)
   {
      this.MargemLucro = MargemLucro;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (Nome != null && !Nome.trim().isEmpty())
         result += "Nome: " + Nome;
      if (precoVenda != null)
         result += ", precoVenda: " + precoVenda;
      result += ", estoque: " + estoque;
      if (precoCusto != null)
         result += ", precoCusto: " + precoCusto;
      if (MargemLucro != null)
         result += ", MargemLucro: " + MargemLucro;
      return result;
   }

   public Set<Fabricante> getFabricante()
   {
      return this.fabricante;
   }

   public void setFabricante(final Set<Fabricante> fabricante)
   {
      this.fabricante = fabricante;
   }
}