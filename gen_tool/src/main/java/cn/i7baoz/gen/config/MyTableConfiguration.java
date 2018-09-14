package cn.i7baoz.gen.config;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;

/** generatorConfig.xml 配置中的table解析
 *      新增的属性应该在此配置
 *          例如 BatchInsert
 * @author ZHANGBAOQI532
 * @date 2018/9/14
 **/
public class MyTableConfiguration extends TableConfiguration {

    private boolean insertStatementEnabled;

    /**
     * 批量新增
     */
    private boolean batchInsertStatementEnabled;

    private boolean updateBatchChangedEnabled;

    private boolean selectByPrimaryKeyStatementEnabled;

    private boolean selectByExampleStatementEnabled;

    private boolean updateByPrimaryKeyStatementEnabled;

    private boolean deleteByPrimaryKeyStatementEnabled;

    private boolean deleteByExampleStatementEnabled;

    private boolean countByExampleStatementEnabled;

    private boolean updateByExampleStatementEnabled;



    public MyTableConfiguration(Context context) {
        super(context);

        insertStatementEnabled = true;
        //批量新增
        batchInsertStatementEnabled = true;
        //批量更新
        updateBatchChangedEnabled = true;

        selectByPrimaryKeyStatementEnabled = true;
        selectByExampleStatementEnabled = true;
        updateByPrimaryKeyStatementEnabled = true;
        deleteByPrimaryKeyStatementEnabled = true;
        deleteByExampleStatementEnabled = true;
        countByExampleStatementEnabled = true;
        updateByExampleStatementEnabled = true;
    }

    @Override
    public boolean isDeleteByPrimaryKeyStatementEnabled() {
        return deleteByPrimaryKeyStatementEnabled;
    }
    @Override
    public void setDeleteByPrimaryKeyStatementEnabled(
            boolean deleteByPrimaryKeyStatementEnabled) {
        this.deleteByPrimaryKeyStatementEnabled = deleteByPrimaryKeyStatementEnabled;
    }
    @Override
    public boolean isInsertStatementEnabled() {
        return insertStatementEnabled;
    }
    @Override
    public void setInsertStatementEnabled(boolean insertStatementEnabled) {
        this.insertStatementEnabled = insertStatementEnabled;
    }

    // 批量新增
    public boolean isBatchInsertStatementEnabled() {
        return batchInsertStatementEnabled;
    }
    // 批量新增
    public void setBatchInsertStatementEnabled(boolean batchInsertStatementEnabled) {
        this.batchInsertStatementEnabled = batchInsertStatementEnabled;
    }
    // 批量更新
    public boolean isUpdateBatchChangedEnabled() {
        return updateBatchChangedEnabled;
    }
    // 批量更新
    public void setUpdateBatchChangedEnabled(boolean updateBatchChangedEnabled) {
        this.updateBatchChangedEnabled = updateBatchChangedEnabled;
    }

    @Override
    public boolean isSelectByPrimaryKeyStatementEnabled() {
        return selectByPrimaryKeyStatementEnabled;
    }
    @Override
    public void setSelectByPrimaryKeyStatementEnabled(
            boolean selectByPrimaryKeyStatementEnabled) {
        this.selectByPrimaryKeyStatementEnabled = selectByPrimaryKeyStatementEnabled;
    }
    @Override
    public boolean isUpdateByPrimaryKeyStatementEnabled() {
        return updateByPrimaryKeyStatementEnabled;
    }
    @Override
    public void setUpdateByPrimaryKeyStatementEnabled(
            boolean updateByPrimaryKeyStatementEnabled) {
        this.updateByPrimaryKeyStatementEnabled = updateByPrimaryKeyStatementEnabled;
    }
    @Override
    public boolean isSelectByExampleStatementEnabled() {
        return selectByExampleStatementEnabled;
    }
    @Override
    public void setSelectByExampleStatementEnabled(
            boolean selectByExampleStatementEnabled) {
        this.selectByExampleStatementEnabled = selectByExampleStatementEnabled;
    }

    @Override
    public boolean isDeleteByExampleStatementEnabled() {
        return deleteByExampleStatementEnabled;
    }
    @Override
    public void setDeleteByExampleStatementEnabled(
            boolean deleteByExampleStatementEnabled) {
        this.deleteByExampleStatementEnabled = deleteByExampleStatementEnabled;
    }

    @Override
    public boolean areAnyStatementsEnabled() {
        return selectByExampleStatementEnabled
                || selectByPrimaryKeyStatementEnabled || insertStatementEnabled
                || batchInsertStatementEnabled
                || updateBatchChangedEnabled
                || updateByPrimaryKeyStatementEnabled
                || deleteByExampleStatementEnabled
                || deleteByPrimaryKeyStatementEnabled
                || countByExampleStatementEnabled
                || updateByExampleStatementEnabled;
    }

    @Override
    public XmlElement toXmlElement() {
        XmlElement xmlElement = super.toXmlElement();

        if (!insertStatementEnabled) {
            xmlElement.addAttribute(new Attribute("enableInsert", "false"));
        }

        if (!batchInsertStatementEnabled) {
            xmlElement.addAttribute(new Attribute("enableBatchInsert", "false"));
        }

        if (!updateBatchChangedEnabled) {
            xmlElement.addAttribute(new Attribute("enableBatchUpdateChanged", "false"));
        }
        return xmlElement;
    }

    @Override
    public boolean isCountByExampleStatementEnabled() {
        return countByExampleStatementEnabled;
    }
    @Override
    public void setCountByExampleStatementEnabled(
            boolean countByExampleStatementEnabled) {
        this.countByExampleStatementEnabled = countByExampleStatementEnabled;
    }
    @Override
    public boolean isUpdateByExampleStatementEnabled() {
        return updateByExampleStatementEnabled;
    }
    @Override
    public void setUpdateByExampleStatementEnabled(
            boolean updateByExampleStatementEnabled) {
        this.updateByExampleStatementEnabled = updateByExampleStatementEnabled;
    }
}
