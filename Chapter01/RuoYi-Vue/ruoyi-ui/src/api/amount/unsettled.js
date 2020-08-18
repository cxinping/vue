import request from '@/utils/request'

// 查询已发货未结算金额列表
export function listUnsettled(query) {
  return request({
    url: '/amount/unsettled/list',
    method: 'get',
    params: query
  })
}

// 查询已发货未结算金额详细
export function getUnsettled(id) {
  return request({
    url: '/amount/unsettled/' + id,
    method: 'get'
  })
}

// 新增已发货未结算金额
export function addUnsettled(data) {
  return request({
    url: '/amount/unsettled',
    method: 'post',
    data: data
  })
}

// 修改已发货未结算金额
export function updateUnsettled(data) {
  return request({
    url: '/amount/unsettled',
    method: 'put',
    data: data
  })
}

// 删除已发货未结算金额
export function delUnsettled(id) {
  return request({
    url: '/amount/unsettled/' + id,
    method: 'delete'
  })
}

// 导出已发货未结算金额
export function exportUnsettled(query) {
  return request({
    url: '/amount/unsettled/export',
    method: 'get',
    params: query
  })
}