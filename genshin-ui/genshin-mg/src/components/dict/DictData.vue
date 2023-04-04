<template>
  <div style="overflow: hidden;">
    <el-container style="height: 89vh">
      <el-aside style="width:150px;">
        <el-button type="text" size="mini" @click="queryTableData">/根目录</el-button>
        <el-button type="primary">确 定</el-button>-->
        <!--        <el-tree :data="treeData" default-expand-all :expand-on-click-node="false" :highlight-current="true"-->
        <!--                 @node-click="clickTeer">-->
        <!--        </el-tree>-->
      </el-aside>

      <el-container style="height: 89vh">
        <el-main>
          <el-card class="box-card" style="height: 100%">
            <!--            <template>-->
            <!--              <el-button type="primary" @click="addDialog">新增</el-button>-->
            <!--              <el-button type="primary">修改</el-button>-->
            <!--              <el-button type="primary">删除</el-button>-->
            <!--              <el-button type="primary">查询</el-button>-->
            <!--            </template>-->

            <!--            <template>-->
            <!--              <el-table :data="tableData" style="margin-top: 15px;height: 90%" empty-text="暂无数据">-->
            <!--                <el-table-column type="selection" width="40"></el-table-column>-->
            <!--                <el-table-column prop="menuName" label="菜单名称"></el-table-column>-->
            <!--                <el-table-column prop="url" label="菜单URL"></el-table-column>-->
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
            <!--              </el-table>-->
            <!--            </template>-->

            <!--            <div style="margin-top: 10px;text-align: right;">-->
            <!--              <el-pagination-->
            <!--                :current-page="tableForm.page"-->
            <!--                :page-sizes="[10, 20, 50, 100]"-->
            <!--                :page-size="tableForm.pageSize"-->
            <!--                layout="total, sizes, prev, pager, next, jumper"-->
            <!--                :total="outherData.total">-->
            <!--              </el-pagination>-->
            <!--            </div>-->
          </el-card>
        </el-main>
      </el-container>
    </el-container>

    <!--弹框-新增页面-->
    <!--    <el-dialog title="新增菜单节点" :visible.sync="outherData.addButtonVisible" width="70%">-->
    <!--      <el-card>-->
    <!--        <el-form>-->
    <!--          <el-form-item label="菜单名称：">-->
    <!--            <el-input v-model="tableForm.menuName" placeholder="请输入内容"></el-input>-->
    <!--          </el-form-item>-->
    <!--          <el-form-item label="菜单跳转地址：">-->
    <!--            <el-input v-model="tableForm.url" placeholder="请输入内容"></el-input>-->
    <!--          </el-form-item>-->
    <!--          <el-form-item label="菜单排序">-->

    <!--          </el-form-item>-->
    <!--          <el-form-item label="备注">-->

    <!--          </el-form-item>-->
    <!--          <el-form-item label="">-->

    <!--          </el-form-item>-->
    <!--          <el-form-item label="">-->

    <!--          </el-form-item>-->
    <!--        </el-form>-->
    <!--        <el-button type="primary">确 定</el-button>-->
    <!--        <el-button @click="outherData.addButtonVisible = false">取 消</el-button>-->
    <!--      </el-card>-->
    <!--    </el-dialog>-->
  </div>
</template>

<script>

</script>

<style>

</style>
