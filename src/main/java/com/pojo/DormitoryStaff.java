package com.pojo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by zhanzhicheng on 11/7/2017.
 */
public class DormitoryStaff extends User {
    private Integer chargedBuildingId;
    private List<RepairingEquipment> repairingEquipments;
    private List<BorrowingKey> borrowingKeys;
    private List<VisitorRecord> visitorRecords;
    private List<SpecialAction> specialActions;
    private List<Student> students;
    private SystemAdministrator systemAdministrator;

    public DormitoryStaff() {

    }

    public SystemAdministrator getSystemAdministrator() {
        return systemAdministrator;
    }

    public void setSystemAdministrator(SystemAdministrator systemAdministrator) {
        this.systemAdministrator = systemAdministrator;
    }

    public Integer getChargedBuildingId() {
        return chargedBuildingId;
    }

    public void setChargedBuildingId(Integer chargedBuildingId) {
        this.chargedBuildingId = chargedBuildingId;
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

    public List<SpecialAction> getSpecialActions() {
        return specialActions;
    }

    public void setSpecialActions(List<SpecialAction> specialActions) {
        this.specialActions = specialActions;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
