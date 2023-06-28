package knu.fit.mit.exam.controller;

import knu.fit.mit.exam.entity.RocketEntity;
import knu.fit.mit.exam.repository.RocketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
@RestController
@RequestMapping("/api/rockets")
@Slf4j
public class RocketController {
    @Autowired
    RocketRepository rocketRepository;
    @GetMapping("/get")
    public List<RocketEntity> getEntities() {
        List<RocketEntity> list;
        log.info("[ROCKET CONTROLLER] Before GET");
        list = rocketRepository.findAll();
        log.info("[ROCKET CONTROLLER] After GET Found {} Rockets", list.size());
        return list;

        }
        @PostMapping("/post")
        @ResponseStatus(HttpStatus.CREATED)
        public RocketEntity postEntity(@RequestBody RocketEntity rocketEntity){
            log.info("[ROCKET CONTROLLER] After POST Found new rocket {} ", rocketEntity);
            return rocketRepository.save(rocketEntity);
        }

        @PutMapping("/update/{id}")
        public RocketEntity putEntity(@PathVariable long id, @RequestBody RocketEntity newEntity){
            RocketEntity updatedEntity = rocketRepository.findById(id)
                    .orElseThrow(() -> new ResourceAccessException("Not found OfficerEntity with id: " + id));
            updatedEntity.setName(newEntity.getName());
            updatedEntity.setImg(newEntity.getImg());
            updatedEntity.setPrice(newEntity.getPrice());
            log.info("[ROCKET CONTROLLER] After PUT Found updated officer {} ", updatedEntity);
            return rocketRepository.save(updatedEntity);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteEntity(@PathVariable long id){
            RocketEntity deletedEntity = rocketRepository.findById(id)
                    .orElseThrow(()-> new ResourceAccessException("Not found rockets with id: "+id));
            log.info("[ROCKET CONTROLLER] After DELETE Found deleted rocket {} ", deletedEntity);
            rocketRepository.deleteById(id);
        }
    }