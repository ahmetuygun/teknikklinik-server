/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.polls.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ygnhmt
 */
@Entity
@Table(name = "transaction_detail", catalog = "teknikklinik2", schema = "")
@NamedQueries({
    @NamedQuery(name = "TransactionDetail.findAll", query = "SELECT t FROM TransactionDetail t")})
public class TransactionDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "trancation_id")
    private int trancationId;
    @Column(name = "offer_id")
    private Integer offerId;

    public TransactionDetail() {
    }

    public TransactionDetail(Integer id) {
        this.id = id;
    }

    public TransactionDetail(Integer id, int trancationId) {
        this.id = id;
        this.trancationId = trancationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTrancationId() {
        return trancationId;
    }

    public void setTrancationId(int trancationId) {
        this.trancationId = trancationId;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionDetail)) {
            return false;
        }
        TransactionDetail other = (TransactionDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.polls.model.TransactionDetail[ id=" + id + " ]";
    }
    
}
