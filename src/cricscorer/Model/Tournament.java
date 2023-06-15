/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Model;

import cricscorer.enumvalues.TournamentType;
import cricscorer.repository.generic.GenericInterface;
import java.time.LocalDate;

/**
 *
 * @author prabin
 */
public class Tournament implements GenericInterface{

    private Integer id;
    private TournamentType type;
    private LocalDate date;

    public Tournament(Integer id, TournamentType type, LocalDate date) {
        this.id = id;
        this.type = type;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public TournamentType getType() {
        return type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setType(TournamentType type) {
        this.type = type;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
