<template>
  <div style="overflow: hidden;">
    <el-container style="height: 89vh">
      <el-aside style="width:150px;">
        <el-button type="text" size="mini" @click="queryTree">/根目录</el-button>
        <el-tree :data="dictTree" default-expand-all :expand-on-click-node="false" :highlight-current="true"
                 @node-click="queryTree"></el-tree>
      </el-aside>

      <el-container style="height: 89vh">
        <el-main>
          <el-card class="box-card" style="height: 100%">
            <template>
              <el-button type="primary" @click="addDict" size="mini">新增</el-button>
              <el-button type="primary" size="mini">修改</el-button>
              <el-button type="primary" size="mini">删除</el-button>
              <el-button type="primary" size="mini">查询</el-button>
            </template>

            <template>
              <el-table :data="dictTable" style="margin-top: 15px;height: 90%" empty-text="暂无数据">
                <el-table-column type="selection" width="40"></el-table-column>
                <el-table-column prop="dictName" label="菜单名称"></el-table-column>
                <el-table-column prop="dictType" label="菜单URL"></el-table-column>
                <!--                <el-table-column prop="parentId" label="父菜单ID"></el-table-column>-->
                <!--                <el-table-column prop="state" label="状态">-->
                <!--                  <template slot-scope="scope">-->
                <!--                    <el-tag type="success" v-if="scope.row.state == '0'" size="mini">正常</el-tag>-->
                <!--                    <el-tag type="danger" v-if="scope.row.state == '1'" size="mini">失效</el-tag>-->
                <!--                  </template>-->
                <!--                </el-table-column>-->
                <!--                <el-table-column prop="sort" label="排序"></el-table-column>-->
                <!--                <el-table-column prop="createTime" label="创建时间"></el-table-column>-->
                <!--                <el-table-column prop="updateTime" label="更新时间"></el-table-column>-->
                <!--                <el-table-column prop="remark" label="备注"></el-table-column>-->
              </el-table>
            </template>

            <div style="margin-top: 10px;text-align: right;">
              <el-pagination
                :current-page="dictForm.page"
                :page-sizes="[10, 20, 50, 100]"
                :page-size="dictForm.pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="outher.total">
              </el-pagination>
            </div>
          </el-card>
        </el-main>
      </el-container>
    </el-container>

    <!--弹框-新增页面-->
    <el-dialog title="新增字典类型" :visible.sync="outher.addButtonVisible" width="70%" :close-on-click-modal="false">
      <el-card>
        <el-form>
          <el-form-item label="字典名称：">
            <el-input v-model="dictForm.dictName" placeholder="请输入字典名称"></el-input>
          </el-form-item>
          <el-form-item label="字典类型：">
            <el-input v-model="dictForm.dictType" placeholder="请输入字典类型"></el-input>
          </el-form-item>
          <el-form-item label="状态">
            <el-radio-group v-model="dictForm.status" size="mini">
              <el-radio-button label="1">正常</el-radio-button>
              <el-radio-button label="2">停用</el-radio-button>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="dictForm.remark" placeholder="请输入备注"></el-input>
          </el-form-item>
        </el-form>
        <el-button type="primary">确 定</el-button>
        <el-button @click="outher.addButtonVisible = false">取 消</el-button>
      </el-card>
    </el-dialog>
  </div>
</template>

<script>
import dictType from '@/api/dict/dictType'

export default {
  data() {
    return {
      outher: {
        total: 0,
        addButtonVisible: false,
      },
      dictForm: {
        dictName: '',
        dictType: '',
        status: '1',
        remark: '',
        page: 1,
        pageSize: 10,
      },
      dictTree: [],
      dictTable: [],
    };
  },
  mounted() {
    this.queryTable()
    this.queryTree()
  },
  methods: {
    queryTree() {
      dictType.tree()
    },
    queryTable() {
      let params = {
        page : this.dictForm.page,
        pageSize : this.dictForm.pageSize
      }
      dictType.qryTable(params)
    },
    addDict() {
      this.outher.addButtonVisible = true;
    }
  }
}
</script>

<style>

</style>
