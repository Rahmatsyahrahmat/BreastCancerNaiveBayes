package com.pengpol.breastcancernaivebayes;

import android.widget.TextView;

import java.util.ArrayList;

public class Data {
    private int id, clumpTickness, cellSize, cellShape, marginalAdhesion, singleEpithelialCellSize, bareNuclei, blandChromatin, normalNucleoli,mitoses, kelas;
    private String message;


    public Data(int id, int clumpTickness, int cellSize, int cellShape, int marginalAdhesion, int singleEpithelialCellSize, int bareNuclei, int blandChromatin, int normalNucleoli, int mitoses, int kelas) {
        this.id = id;
        this.clumpTickness = clumpTickness;
        this.cellSize = cellSize;
        this.cellShape = cellShape;
        this.marginalAdhesion = marginalAdhesion;
        this.singleEpithelialCellSize = singleEpithelialCellSize;
        this.bareNuclei = bareNuclei;
        this.blandChromatin = blandChromatin;
        this.normalNucleoli = normalNucleoli;
        this.mitoses = mitoses;
        this.kelas = kelas;
    }
    public Data(int id, int clumpTickness, int cellSize, int cellShape, int marginalAdhesion, int singleEpithelialCellSize, int bareNuclei, int blandChromatin, int normalNucleoli, int mitoses) {
        this.id = id;
        this.clumpTickness = clumpTickness;
        this.cellSize = cellSize;
        this.cellShape = cellShape;
        this.marginalAdhesion = marginalAdhesion;
        this.singleEpithelialCellSize = singleEpithelialCellSize;
        this.bareNuclei = bareNuclei;
        this.blandChromatin = blandChromatin;
        this.normalNucleoli = normalNucleoli;
        this.mitoses = mitoses;
        message = "";
    }


    public int getClumpTickness() {
        return clumpTickness;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getCellShape() {
        return cellShape;
    }

    public int getMarginalAdhesion() {
        return marginalAdhesion;
    }

    public int getSingleEpithelialCellSize() {
        return singleEpithelialCellSize;
    }

    public int getBareNuclei() {
        return bareNuclei;
    }

    public int getBlandChromatin() {
        return blandChromatin;
    }

    public int getNormalNucleoli() {
        return normalNucleoli;
    }

    public int getMitoses() {
        return mitoses;
    }

    public int getId() {
        return id;
    }
    public int getKelas() {
        return kelas;
    }
    public  double probabilitasJinak(ArrayList<Data> datas){
        double count = 0;
        for(Data d:datas){
            if (d.getKelas()==2) count++;
        }
        message = message+"P(Jinak) = "+count/datas.size()+"\n";
        return count/datas.size();
    }
    public double probabilitasGanas(ArrayList<Data> datas){
        double count = 0;
        for(Data d:datas){
            if (d.getKelas()==4) count++;
        }
        message = message+"P(Ganas) = "+count/datas.size()+"\n";
        return count/datas.size();
    }

    public double likelihoodClumpTicknessJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getClumpTickness()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Clump Tickness|Jinak) = "+result+"\n";
        return result;
    }

    public double likelihoodCellSizeJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getCellSize()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Uniformity of Cell Size|Jinak) = "+result+"\n";
        return result;
    }

    public double likelihoodCellShapeJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getCellShape()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Uniformity of Cell Shape|Jinak) = "+result+"\n";
        return result;
    }

    public double likelihoodMarginalAdhesionJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getMarginalAdhesion()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Marginal Adhesion|Jinak) = "+result+"\n";
        return result;
    }

    public double likelihoodSingleEpithelialCellSizeJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getSingleEpithelialCellSize()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Single Epithalil Cell Size|Jinak) = "+result+"\n";
        return result;
    }

    public double likelihoodBareNucleiJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getBareNuclei()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Bare Nuclei|Jinak) = "+result+"\n";
        return result;
    }

    public double likelihoodBlandChromatinJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getBlandChromatin()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Bland Chromation|Jinak) = "+result+"\n";
        return result;
    }


    public double likelihoodNormalNucleoliJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getNormalNucleoli()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Normal Nucleoli|Jinak) = "+result+"\n";
        return result;
    }

    public double likelihoodMitosesJinak(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getMitoses()==income&&d.getKelas()==2) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Mitoses|Jinak) = "+result+"\n";
        return result;
    }
    public double likelihoodClumpTicknessGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getClumpTickness()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Clump Tickness|Ganas) = "+result+"\n";
        return result;
    }

    public double likelihoodCellSizeGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getCellSize()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Uniformity of Cell Size|Ganas) = "+result+"\n";
        return result;
    }

    public double likelihoodCellShapeGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getCellShape()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Uniformity of Cell Shape|Ganas) = "+result+"\n";
        return result;
    }

    public double likelihoodMarginalAdhesionGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getMarginalAdhesion()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Marginal Adhesion|Ganas) = "+result+"\n";
        return result;
    }

    public double likelihoodSingleEpithelialCellSizeGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getSingleEpithelialCellSize()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Single Ephitalial Cell Size|Ganas) = "+result+"\n";
        return result;
    }

    public double likelihoodBareNucleiGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getBareNuclei()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(BareNuclei|Ganas) = "+result+"\n";
        return result;
    }

    public double likelihoodBlandChromatinGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getBlandChromatin()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Bland Chromatiin|Ganas) = "+result+"\n";
        return result;
    }


    public double likelihoodNormalNucleoliGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getNormalNucleoli()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Normal Nucleoli|Ganas) = "+result+"\n";
        return result;
    }

    public double likelihoodMitosesGanas(ArrayList<Data> datas, int income) {
        double count = 0;
        for (Data d: datas){
            if (d.getMitoses()==income&&d.getKelas()==4) count++;
        }
        double result;
        if (count==0){
            result = 1/(datas.size()+2);
        }
        else {
            result = count/datas.size();
        }
        message = message+"P(Mitoses|Ganas) = "+result+"\n";
        return result;
    }
    public void getKelas(ArrayList<Data> datas, TextView tv){
        double jinak = probabilitasJinak(datas)*likelihoodClumpTicknessJinak(datas,getClumpTickness())*likelihoodCellSizeJinak(datas,getCellSize())*likelihoodCellShapeJinak(datas,getCellShape())*likelihoodMarginalAdhesionJinak(datas,getMarginalAdhesion())*likelihoodSingleEpithelialCellSizeJinak(datas,getSingleEpithelialCellSize())*likelihoodBareNucleiJinak(datas, getBareNuclei())*likelihoodBlandChromatinJinak(datas, getBlandChromatin())*likelihoodNormalNucleoliJinak(datas, getNormalNucleoli())*likelihoodMitosesJinak(datas, getMitoses());
        double ganas = probabilitasGanas(datas)*likelihoodClumpTicknessGanas(datas,getClumpTickness())*likelihoodCellSizeGanas(datas,getCellSize())*likelihoodCellShapeGanas(datas,getCellShape())*likelihoodMarginalAdhesionGanas(datas,getMarginalAdhesion())*likelihoodSingleEpithelialCellSizeGanas(datas,getSingleEpithelialCellSize())*likelihoodBareNucleiGanas(datas, getBareNuclei())*likelihoodBlandChromatinGanas(datas, getBlandChromatin())*likelihoodNormalNucleoliGanas(datas, getNormalNucleoli())*likelihoodMitosesGanas(datas, getMitoses());
        message = message+"P(Jinak) = "+jinak+"\n";
        message = message+"P(Ganas) = "+ganas+"\n";
        if(jinak>ganas){
            message = message+"Termasuk kelas Jinak";
        }
        else {
            message = message+"Termasuk kelas Ganas";
        }
        tv.setText(message);
    }

}
