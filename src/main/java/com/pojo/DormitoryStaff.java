package com.pojo;

import java.util.List;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class DormitoryStaff extends User {
    private Integer chargedBuidingId;
    private List<RepairingEquipment> repairingEquipments;
    private List<BorrowingKey> borrowingKeys;
    private List<VisitorRecord> visitorRecords;
    private List<SpecialAction> speicalActions;
    private List<Student> students;

    public DormitoryStaff(Integer chargedBuidingId, List<RepairingEquipment> repairingEquipments,
                          List<BorrowingKey> borrowingKeys, List<VisitorRecord> visitorRecords, List<SpecialAction> speicalActions, List<Student> students) {
        this.chargedBuidingId = chargedBuidingId;
        this.repairingEquipments = repairingEquipments;
        this.borrowingKeys = borrowingKeys;
        this.visitorRecords = visitorRecords;
        this.speicalActions = speicalActions;
        this.students = students;
    }

    public Integer getChargedBuidingId() {
        return chargedBuidingId;
    }

    public void setChargedBuidingId(Integer chargedBuidingId) {
        this.chargedBuidingId = chargedBuidingId;
    }

    public List<RepairingEquipment> getRepairingEquipments() {
        return repairingEquipments;
    }

    public void setRepairingEquipments(List<RepairingEquipment> repairingEquipments) {
        this.repairingEquipments = repairingEquipments;
    }

    public List<BorrowingKey> getBorrowingKeys() {
        return borrowingKeys;
    }

    public void setBorrowingKeys(List<BorrowingKey> borrowingKeys) {
        this.borrowingKeys = borrowingKeys;
    }

    public List<VisitorRecord> getVisitorRecords() {
        return visitorRecords;
    }

    public void setVisitorRecords(List<VisitorRecord> visitorRecords) {
        this.visitorRecords = visitorRecords;
    }

    public List<SpecialAction> getSpeicalActions() {
        return speicalActions;
    }

    public void setSpeicalActions(List<SpecialAction> speicalActions) {
        this.speicalActions = speicalActions;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
