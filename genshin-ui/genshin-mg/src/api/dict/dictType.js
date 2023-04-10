import request from '@/utils/request'

export default {
  qryTree() {
    return request({
      url: '/sys/dict/tree/',
      method: 'GET'
    })
  },
  qryTable(data){
    return request({
      url: '/sys/dictType/page/',
      method: 'POST',
      data: data
    })
  },
  svDictType(data){
    return request({
      url: '/sys/dictType/add/',
      method: 'POST',
      data: data
    })
  }
}
