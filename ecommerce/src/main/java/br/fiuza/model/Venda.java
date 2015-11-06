package br.fiuza.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import br.fiuza.model.Cliente;
import br.fiuza.model.Produto;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Venda implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column
   private Cliente cliente;

   @Column
   private Produto produto;

   @Column
   private Double valorItem;

   @Column
   private Double valorTotal;

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
      if (!(obj instanceof Venda))
      {
         return false;
      }
      Venda other = (Venda) obj;
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

   public Cliente getCliente()
   {
      return cliente;
   }

   public void setCliente(Cliente cliente)
   {
      this.cliente = cliente;
   }

   public Produto getProduto()
   {
      return produto;
   }

   public void setProduto(Produto produto)
   {
      this.produto = produto;
   }

   public Double getValorItem()
   {
      return valorItem;
   }

   public void setValorItem(Double valorItem)
   {
      this.valorItem = valorItem;
   }

   public Double getValorTotal()
   {
      return valorTotal;
   }

   public void setValorTotal(Double valorTotal)
   {
      this.valorTotal = valorTotal;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (valorItem != null)
         result += "valorItem: " + valorItem;
      if (valorTotal != null)
         result += ", valorTotal: " + valorTotal;
      return result;
   }
}