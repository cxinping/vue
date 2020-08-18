import request from '@/utils/request'

// 查询统计页面列表
export function listStatistics(query) {
  return request({
    url: '/amount/statistics/list',
    method: 'get',
    params: query
  })
}

// 查询统计页面详细
export function getStatistics(id) {
  return request({
    url: '/amount/statistics/' + id,
    method: 'get'
  })
}

// 新增统计页面
export function addStatistics(data) {
  return request({
    url: '/amount/statistics',
    method: 'post',
    data: data
  })
}

// 修改统计页面
export function updateStatistics(data) {
  return request({
    url: '/amount/statistics',
    method: 'put',
    data: data
  })
}

// 删除统计页面
export function delStatistics(id) {
  return request({
    url: '/amount/statistics/' + id,
    method: 'delete'
  })
}

// 导出统计页面
export function exportStatistics(query) {
  return request({
    url: '/amount/statistics/export',
    method: 'get',
    params: query
  })
}