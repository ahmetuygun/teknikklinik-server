/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.polls.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ygnhmt
 */
@Entity
@Table(name = "transaction", catalog = "teknikklinik2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "current_status_id")
    private Integer currentStatusId;
    @Column(name = "description")
    private String description;
    @Column(name = "kurye")
    private Integer kurye;
    @Column(name = "t_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tDate;
    @Column(name = "fixer_id")
    private Integer fixerId;
    @Column(name = "undefined_defect")
    private Integer undefinedDefect;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
    private Collection<TransactionHistory> transactionHistoryCollection;

    public Transaction() {
    }

    public Transaction(Integer id) {
        this.id = id;
    }

    public Transaction(Integer id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getCurrentStatusId() {
        return currentStatusId;
    }

    public void setCurrentStatusId(Integer currentStatusId) {
        this.currentStatusId = currentStatusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getKurye() {
        return kurye;
    }

    public void setKurye(Integer kurye) {
        this.kurye = kurye;
    }

    public Date getTDate() {
        return tDate;
    }

    public void setTDate(Date tDate) {
        this.tDate = tDate;
    }

    public Integer getFixerId() {
        return fixerId;
    }

    public void setFixerId(Integer fixerId) {
        this.fixerId = fixerId;
    }

    public Integer getUndefinedDefect() {
        return undefinedDefect;
    }

    public void setUndefinedDefect(Integer undefinedDefect) {
        this.undefinedDefect = undefinedDefect;
    }

    public Collection<TransactionHistory> getTransactionHistoryCollection() {
        return transactionHistoryCollection;
    }

    public void setTransactionHistoryCollection(Collection<TransactionHistory> transactionHistoryCollection) {
        this.transactionHistoryCollection = transactionHistoryCollection;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.polls.model.Transaction[ id=" + id + " ]";
    }
    
}
